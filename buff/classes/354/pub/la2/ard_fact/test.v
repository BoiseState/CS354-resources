`timescale 1ns/100ps

module test#(BITS='d4, WORDS='d6)();

   reg clk, init;
   reg busena[3:1];
   wire busdir[3:1];

   wire [BITS-1:0]ardbus;
   reg ardrd, ardwr;

   ard_fact#(.BITS(BITS), .WORDS(WORDS))
        fact(.CLK66(clk), .INIT(init),
             .BusEna(busena), .BusDir(busdir),
	     .ARDrd(ardrd), .ARDwr(ardwr),
             .ARDbus(ardbus),
             .SWS(), .LEDS());

   // Use strength to override ARD input during simulation.
   reg  [BITS-1:0]ard_inp;
   wire [BITS-1:0]ard_out;
   assign (supply0,supply1)ardbus=ard_inp;
   assign ard_out=fact.bus.Inp;

   always #7.5 clk=~clk;        // create a 66Mhz clock (15ns period)

   reg [WORDS*BITS-1:0]res;
   assign res=words;		// $display unsigned

   integer i,j,words;
   initial begin
      clk=1'b0;                 // enabled
      // 0 1 2 3  4   5   6
      // 1 1 2 6 24 120 720
      init=0; #100 init=1; #100 ardrd=0; #100 init=0;
      for (i=0; i<=15; i++) begin // 32 bit
         #100 words=i;
         // *** Is the last computation done?
         wait(!fact.fn_oe);     // ardbus.v: wait to be in StRD
         for (j=1; j<=WORDS; j++)
           begin
	      ard_inp=words[(j*BITS-1)-:BITS];
              ardrd=0;
              wait(!ardwr);	// for EPT to be in StENAB
              ardrd=1;		// StENAB->StREAD
              wait(ardwr);	// for EPT to be in StREAD
              ardrd=0;		// StREAD->StENAB/StDONE
              wait(!ardwr);	// for EPT to be in StENAB/StDONE
           end
         wait(fact.fn_oe);	// for fn, and to be in StWR
	 words=0;
         for (j=1; j<=WORDS; j++)
           begin
              ardrd=0;
              wait(!ardwr);	// for EPT to be in StENAB
              ardrd=1;		// StENAB->StWRIT
              wait(ardwr);	// for EPT to be in StWRIT
	      words[(j*BITS-1)-:BITS]=ard_out;
              ardrd=0;		// StWRIT->StENAB/StDONE
              wait(!ardwr);	// for EPT to be in StENAB/StDONE
           end
         wait(fact.io.OE);      // to be in StINIT
         $display("fact(%3d)=%20d(%h)",fact.inp,res,res);
      end
      $stop;
   end

// `include "monitor.mon"
// gtkwave test.fst &
// `include "dump"

endmodule
