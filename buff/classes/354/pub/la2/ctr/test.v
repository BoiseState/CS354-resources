`timescale 1ns/100ps

module ctr#(BITS=8)();

   reg clk;
   reg [BITS]inp, out;		// unsigned
   reg ie, oe;			// input/output enable
   reg ce;			// count enable
   reg decr;			// count up/down
   reg [BITS]stop;		// unsigned upto/downto
   reg init, done;		// are we?

   Counter#(.BITS(BITS))
       c(.CLK(clk),
	 .INP(inp), .IE(ie),
	 .OUT(out), .OE(oe),
         .DECR(decr), .STOP(stop),
	 .CE(ce),
	 .INIT(init), .DONE(done));

   always #7.5 clk=~clk;	// create a 66Mhz clock (15ns period)

   initial begin
      clk=1'b0;			// enabled
      #10;
      ie=1; ce=0;
      decr=0; inp=1; stop=5;
      //decr=0; inp=1; stop=1;
      //decr=0; inp=0; stop=0;
      //decr=0; inp=1; stop=0;
      //decr=1; inp=9; stop=1;
      //decr=1; inp=1; stop=1;
      //decr=1; inp=0; stop=0;
      //decr=1; inp=0; stop=1;
      wait (init);		// ready
      ie=0;			// inputs latched during ie
      while (!done) begin
	 ce=0;			// make oe true
	 wait (oe || done);	// until output good
	 if (!done)
	   $display("ctr(%1d,%1d,%1d)=%1d",inp,stop,decr,out);
	 ce=1;			// make oe false
	 wait (!oe);		// ready
      end
      wait (!oe);		// ready
      #10;
      $stop;
   end

//`include "monitor"
// gtkwave test.fst &
//`include "dump"

endmodule
