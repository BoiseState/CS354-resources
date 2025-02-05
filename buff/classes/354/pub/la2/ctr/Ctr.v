module Counter#(BITS='d32)(
    input CLK,
    input [BITS-1:0]INP,        // unsigned
    input IE,
    output reg [BITS-1:0]OUT,   // unsigned
    output reg OE,
    input DECR,                 // 0: ++, 1:--
    input [BITS-1:0]STOP,       // OUT<=[INP..STOP] according to DECR
    input CE,                   // strobe to count
    output reg INIT, DONE);

   localparam one=BITS'(1);

   typedef enum {StTST,StOE1,StOE0,StCNT,StEND} State;
   State curr, next;

   always @(posedge CLK or posedge IE)
     if (IE) begin              // Wait for ~IE.
        INIT<=1; OE<=0; DONE<=0;
        OUT<=INP;
        curr<=StTST;
     end else begin
        case (next)
          StOE1: OE<=1;
          StOE0: begin INIT<=0; OE<=0; end
          StEND: DONE<=1;
          StCNT: OUT<=(|DECR ? OUT-one : OUT+one);
        endcase
        curr<=next;
     end

   always @* begin #2;
      next=curr;
      case (curr)
        StTST: if (|DECR            // 0: Are we done?
                   ? (OUT[BITS-1:0]<STOP[BITS-1:0] || &OUT)
                   : (OUT[BITS-1:0]>STOP[BITS-1:0]))
                        next=StEND;
               else     next=StOE1;
        StOE1: if (CE)  next=StOE0; // 1: Wait for CE.
        StOE0: if (!CE) next=StCNT; // 2: Wait for ~CE.
        StCNT:          next=StTST; // 3: Decrement or increment.
      endcase
   end

endmodule
