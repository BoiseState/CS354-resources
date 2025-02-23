`timescale 1ns/100ps

module clk#(Div=1)();

   reg CLK66, CLK33, CLK22;

   Clk#(.Div(0)) c33(.Base(CLK66), .Gen(CLK33));
   Clk#(.Div(1)) c22(.Base(CLK66), .Gen(CLK22));
   Clk#(.Div(2)) c15(.Base(CLK66), .Gen(CLK15));
   Clk#(.Div(3)) c05(.Base(CLK66), .Gen(CLK05));

   always #7.5 CLK66=~CLK66;        // create a 66Mhz clock (15ns period)

   integer i;
   initial begin
      CLK66=1'b0;
      for (i=0; i<200; i++) begin
	 #1;
	 $display("w22=%2d, cnt22=%3b, w33=%2d, cnt33=%3b",c22.width,c22.cnt,c33.width,c33.cnt);
         $display("i=%d, CLK66=%b, CLK33=%b CLK22=%b CLK15=%b",i,CLK66,CLK33,CLK22,CLK15);
      end
      $stop;
   end

// `include "monitor.mon"
// gtkwave test.fst &
`include "dump"

endmodule
