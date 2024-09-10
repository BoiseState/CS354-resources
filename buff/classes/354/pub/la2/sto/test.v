`timescale 1ns/100ps

module sto#(BITS=8)();

   reg clk;
   reg [BITS]inp, out;
   reg ie, oe;			// input/output enable
   reg init;

   Store#(.BITS(BITS))
       s(.CLK(clk),
	 .INP(inp), .IE(ie),
	 .OUT(out), .OE(oe),
	 .INIT(init));

   always #7.5 clk=~clk;	// create a 66Mhz clock (15ns period)

   integer i;
   initial begin
      clk=1'b0;			// enabled
      #30 ie=0; init=1;
      #30 ie=1;
      wait (oe);		// until output good
      #30 ie=0;			// output good until both ie go false
      wait (!oe);		// until ready for more
      for (i=1; i<10; i++) begin
	 #30 inp=i; init=0;	// provide input
	 $display("sto(0..9)=%1d,%1d",out,inp);
	 #30 ie=1;		// input latched when ie goes true
	 wait (oe);		// until output good
         #30 ie=0;	        // output good until both ie go false
	 wait (!oe);		// until ready for more
      end
     $stop;
   end

//`include "monitor"

endmodule
