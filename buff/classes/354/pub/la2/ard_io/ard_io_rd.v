module ard_io_rd#(BITS='d4, WORDS='d1)(  // little endian
    input CLK, input INIT,
    output reg ARDOutEn,           // EPT<--ARD bus input enable
    input ARDOutOk,                // EPT<--ARD bus input ready
    input [BITS-1:0]ARDOut,        // EPT<--ARD bus
    output reg [WORDS*BITS-1:0]Out,// aggregate output to fact/fib/etc
    input IE, output reg OE,
    input SWS[2:1], output reg [2:0]LED);

   localparam inxwidth=$clog2(WORDS*BITS)-1;
   localparam bit [inxwidth:0]zero=0, one=1;
   reg [inxwidth:0]word, index; // just the right size

`include "led"

   typedef enum {StINIT,StENAB,StREAD,StINCR,StTEST,StDONE} State;
   State curr, next;
   
   initial begin
      ARDOutEn=0;
      OE=0;
      curr<=StINIT;
      next<=StINIT;
   end
   
   always @(posedge CLK or posedge INIT)
     if (INIT) curr<=StINIT;
     else      curr<=next;

   always @* begin #2;
      LED=lOFF;
      ARDOutEn=0;
      OE=0;                      // disable Out
      case (curr)
         StINIT: begin LED=lRED; // 0: Wait to start read loop.
            if (IE) next=StENAB;
            else    next=StINIT;
           end
         StENAB: begin LED=lGRN; // 1: Enable reading from ARD.
            if (!ARDOutOk) next=StREAD;
            else           next=StENAB;
         end
         StREAD: begin LED=lYEL; // 2: Read from ARD.
            ARDOutEn=1;          // enable input from ARD
            if (ARDOutOk) next=StINCR;
            else          next=StREAD;
         end
         StINCR: begin          // 3: Increment.
            next=StTEST;
         end
         StTEST: begin          // 4: Done reading words?
            if (|word) next=StREAD;
            else       next=StDONE;
         end
         StDONE: begin LED=lWHT; // 5: Done reading words.
            OE=1;                // enable Out
            if (!IE) next=StINIT;
            else     next=StDONE;
         end
      endcase
   end
      
   always @(posedge CLK)
     case (curr)
       StINIT: begin
          word<=WORDS[inxwidth:0];
          index<=0;
       end
       StINCR: begin
          Out[index+:BITS]<=ARDOut; // input data
          word<=word-one;
          index<=index+BITS[inxwidth:0];
       end
     endcase

endmodule
