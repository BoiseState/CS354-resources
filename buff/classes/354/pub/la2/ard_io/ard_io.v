module ard_io#(BITS='d4, WORDS='d1)(
    input CLK, input INIT,
    output reg ARDOutEn,           // EPT<--ARD bus input enable
    input ARDOutOk,                // EPT<--ARD bus input ready
    input  [BITS-1:0]ARDOut,       // word I/O from ARD
    output reg ARDInpEn,           // EPT-->ARD bus output enable
    input ARDInpOk,                // EPT-->ARD bus output ready
    output [BITS-1:0]ARDInp,       // word I/O to ARD
    output [WORDS*BITS-1:0]Inp,    // aggregate input from ARD
    input  [WORDS*BITS-1:0]Out,    // aggregate output to ARD
    input  IE, output reg OE,
    input SWS[2:1], output [2:0]LEDS[3:1]);

   reg rd_ie; wire rd_oe;       // internal input/output enable
   reg wr_ie; wire wr_oe;       // internal input/output enable

   ard_io_rd#(.BITS(BITS), .WORDS(WORDS))
          rd(.CLK, .INIT,
             .ARDOutEn,         // EPT<--ARD bus input enable
             .ARDOutOk,         // EPT<--ARD bus input ready
             .ARDOut,           // EPT<--ARD bus input
             .Out(Inp),         // ARD -> fn
             .IE(rd_ie), .OE(rd_oe),
             .LED(LEDS[2]), .SWS);

   ard_io_wr#(.BITS(BITS), .WORDS(WORDS))
          wr(.CLK, .INIT,
             .ARDInpEn,         // EPT-->ARD bus output enable
             .ARDInpOk,         // EPT-->ARD bus output ready
             .ARDInp,           // EPT-->ARD bus output
             .Inp(Out),         // output of fn
             .IE(wr_ie), .OE(wr_oe),
             .LED(LEDS[3]), .SWS);

`include "led"
   reg [2:0]LED; assign LEDS[1]=LED;

   typedef enum {StINIT,StRD,StFN,StWR} State;
   State curr, next;

   initial begin
      rd_ie=0;
      wr_ie=0;
      OE=1;
      curr<=StINIT;
      next<=StINIT;
   end

   always @(posedge CLK or posedge INIT)
     if (INIT) curr<=StINIT;
     else      curr<=next;

   always @* begin #2;
      LED=lOFF;
      rd_ie=0;
      wr_ie=0;
      OE=1;                     // enable fn (Ctr.IE)
      case (curr)
        StINIT: begin LED=lRED; // 0: wait for fn (!Ctr.DONE)
           if (!rd_oe && !wr_oe && !IE) next=StRD;
           else                         next=StINIT;
        end
        StRD: begin LED=lGRN;   // 1: read input data
           rd_ie=1;
           if (rd_oe) next=StFN;
           else       next=StRD;
        end
        StFN: begin LED=lBLU;    // 2: compute output data from input data
           rd_ie=1;
           OE=0;                // start fn (Ctr.IE)
           if (IE) next=StWR;   // wait for fn (Ctr.DONE)
           else    next=StFN;
        end
        StWR: begin LED=lWHT;   // 3: write output data
           wr_ie=1;
           OE=0;
           if (wr_oe) next=StINIT;
           else       next=StWR;
        end
      endcase
   end

endmodule
