module Sync#(STAGES='d2, BITS='d1)(
  input  clk,
  input  [BITS-1:0]in,
  output [BITS-1:0]out);
 
   reg [BITS-1:0]stage[STAGES:1];
 
   always @(posedge clk) begin
      integer i;
      for (i=STAGES; i>1; i=i-1)
	 stage[i]<=stage[i-1];
      stage[1]<=in;
   end
 
   assign out=stage[STAGES];
 
endmodule
