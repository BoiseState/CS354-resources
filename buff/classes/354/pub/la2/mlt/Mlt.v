module Multiplier#(BITS=32, CLKS=3'd0)(
    input CLK,
    input [BITS-1:0]A, B,
    input IEA, IEB,
    output reg [BITS-1:0]Y,
    output reg OE);

   reg [BITS-1:0]a, b;

   reg [2:0]cnt;		// extra clocks for multiplication

   enum {StINIT,StA,StB,StAB,StOE} state;

   initial begin
      state<=StINIT;
   end

   always @ (posedge CLK) begin
      case (state)
	StINIT: begin
	   cnt<=CLKS;
	   OE<=0;
	   if (IEA && !IEB) begin
	      a<=A; state<=StA;
	   end
	   if (!IEA && IEB) begin
	      b<=B; state<=StB;
	   end
	   if (IEA && IEB) begin
	      a<=A; b<=B; state<=StAB;
	   end
	end
	StA: begin
	   if (IEB) begin
	      b<=B; state<=StAB;
	   end
	end
	StB: begin
	   if (IEA) begin
	      a<=A; state<=StAB;
	   end
	end
	StAB: begin
	   Y<=a*b;
	   if (cnt)
	     cnt<=(cnt-3'b1);
	   else
	     state<=StOE;
	end
	StOE: begin
	   OE<=1;
	   if (OE && !IEA && !IEB)
	     state<=StINIT;
	end
      endcase
   end
      
endmodule
