`timescale 1ns/100ps

module mux#(BITS=8)();

   reg clk;
   reg [BITS]a, b, y;
   reg ie, oe;			// input/output enable
   reg sel;			// 0->A, 1->B

   Multiplexer#(.BITS(BITS))
       m(.CLK(CLK),
	 .A(a), .B(b), .Y(y),
	 .IE(ie), .OE(oe),
	 .SEL(sel));

   always #7.5 clk=~clk;	// create a 66Mhz clock (15ns period)

   initial begin
      clk=1'b0;			// enabled
      ie=0;
      #30 a=1; b=2; sel=0;	// provide and select input
      #30 ie=1;		        // so oe goes true
      wait (oe);		// until output good
      $display("mux(%1d,%1d,%1d)=%1d",a,b,sel,y);
      ie=0;			// got it
      wait (!oe);		// until ready for more
      #30 sel=1;		// select input
      #30 ie=1;			// so oe goes true
      wait (oe);		// until output good
      $display("mux(%1d,%1d,%1d)=%1d",a,b,sel,y);
      ie=0;			// got it
      wait (!oe);		// until ready for more
      $stop;
   end

// `include "monitor"

endmodule
