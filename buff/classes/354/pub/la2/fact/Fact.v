module Factorial#(BITS='d32)(
    input CLK,
    input      [BITS-1:0]INP, input      IE,
    output reg [BITS-1:0]OUT, output reg OE);

   wire [BITS-1:0]ctr_out, mlt_out;
   wire mux_oe, ctr_oe, ctr_init, mlt_oe;

   localparam false=1'b0;
   localparam true=1'b1;
   localparam zero=BITS'(0);
   localparam one=BITS'(1);

   Multiplexer#(.BITS(BITS))
       mux(.CLK,
	   .A(mlt_out), .B(one),
	   .Y(OUT),
	   .IE(ctr_oe), .OE(mux_oe),
	   .SEL(ctr_init));	// 0->A, 1->B

   Counter#(.BITS(BITS))
       ctr(.CLK,
	   .INP(INP),     .IE(IE),
	   .OUT(ctr_out), .OE(ctr_oe),
           .DECR(true),		// count down
           .STOP(one),		// for (OUT=INP; OUT>1; OUT--)
	   .CE(mlt_oe),
	   .INIT(ctr_init), .DONE(OE));

   Multiplier#(.BITS(BITS))
       mlt(.CLK,
	   .A(OUT),      .B(ctr_out),
	   .IEA(mux_oe), .IEB(ctr_oe),
	   .Y(mlt_out),  .OE(mlt_oe));

endmodule
