module Multiplier#(BITS='d32)(
    input CLK,
    input [BITS-1:0]A, B,
    input IEA, IEB,
    output [BITS-1:0]Y,
    output reg OE);

   reg [BITS-1:0]a, b;

   assign Y=a*b;

   enum {StINIT,StA,StB,StOE} state;

   initial state<=StINIT;

   always @ (posedge CLK)
      case (state)
        StINIT: begin
           OE<=0;
           if (IEA && !IEB) begin
              a<=A; state<=StA;
           end
           if (!IEA && IEB) begin
              b<=B; state<=StB;
           end
           if (IEA && IEB) begin
              a<=A; b<=B; state<=StOE;
           end
        end
        StA: begin
           if (IEB) begin
              b<=B; state<=StOE;
           end
        end
        StB: begin
           if (IEA) begin
              a<=A; state<=StOE;
           end
        end
        StOE: begin
           OE<=1;
           if (OE && !IEA && !IEB)
             state<=StINIT;
        end
      endcase
      
endmodule
