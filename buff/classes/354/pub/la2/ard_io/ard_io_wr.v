module ard_io_wr#(BITS='d4, WORDS='d1)(  // little endian
    input CLK, input INIT,
    output reg ARDInpEn,           // EPT-->ARD bus output enable
    input ARDInpOk,                // EPT-->ARD bus output ready
    output reg [BITS-1:0]ARDInp,   // EPT<->ARD bus
    input [WORDS*BITS-1:0]Inp,     // input from fact/fib/etc
    input IE, output reg OE,
    input SWS[2:1], output reg [2:0]LED);

   localparam inxwidth=$clog2(WORDS*BITS)-1;
   localparam bit [inxwidth:0]zero=0, one=1;
   reg [inxwidth:0]word, index; // just the right size

`include "led"

   typedef enum {StINIT,StENAB,StWRIT,StINCR,StTEST,StDONE} State;
   State curr, next;

   initial begin
      ARDInpEn=0;
      OE=0;
      curr<=StINIT;
      next<=StINIT;
   end
   
   always @(posedge CLK or posedge INIT)
     if (INIT) curr<=StINIT;
     else      curr<=next;

   always @* begin #2;
      LED=lOFF;
      ARDInpEn=0;
      OE=0;                      // disable Out
      case (curr)
        StINIT: begin LED=lRED; // 0: Wait to start write loop.
           if (IE) next=StENAB;
           else    next=StINIT;
        end
        StENAB: begin LED=lGRN; // 1: Enable writing to ARD.
           if (!ARDInpOk) next=StWRIT;
           else           next=StENAB;
        end
        StWRIT: begin LED=lBLU; // 2: Write to ARD.
           ARDInpEn=1;          // enable output to ARD
           if (ARDInpOk) next=StINCR;
           else          next=StWRIT;
        end
        StINCR: begin           // 3: Increment.
           next=StTEST;
        end
        StTEST: begin          // 4: Done writing words?
           if (|word) next=StWRIT;
           else       next=StDONE;
        end
        StDONE: begin LED=lWHT; // 5: Done writing words.
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
       StWRIT: begin
          ARDInp<=Inp[index+:BITS]; // output data
       end
       StINCR: begin
          word<=word-one;
          index<=index+BITS[inxwidth:0];
       end
     endcase

endmodule
