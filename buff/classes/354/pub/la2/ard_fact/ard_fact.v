module ard_fact#(BITS=8)(
    input CLK,
    input INIT,                              // active low
    output reg TR_OE_1,  TR_OE_2,  TR_OE_3,  // EPT<->ARD bus enable (low)
    output reg TR_DIR_1, TR_DIR_2, TR_DIR_3, // EPT<->ARD bus direction
    inout [BITS-1:0]LB_IO,                   // EPT<->ARD bus
    input reg ARD_RD, output reg ARD_WR,     // EPT<->ARD bus control (low)
    output [2:0]LEDS[4:1]);

   wire [BITS-1:0]inp, // data read: ARD -> EPT
                  out; // data writ: EPT -> ARD
   wire ie, oe;        // input/output enable

   ard_io io(.CLK(CLK),
             .INIT(INIT),                      // active low
             .TR_OE_1(TR_OE_1),   .TR_OE_2(TR_OE_2),   .TR_OE_3(TR_OE_3),
             .TR_DIR_1(TR_DIR_1), .TR_DIR_2(TR_DIR_2), .TR_DIR_3(TR_DIR_3),
             .LB_IO(LB_IO),
             .ARD_RD(ARD_RD), .ARD_WR(ARD_WR), // active low
             .INP(inp),                        // input from ARD
             .OUT(out),                        // output to ARD
             .IE(ie),                          // for INP
             .OE(oe),                          // for OUT
	     .LEDS(LEDS));

   Factorial#(.BITS(BITS))
        fact(.CLK(CLK),
             .INP(inp), .IE(ie),
             .OUT(out), .OE(oe));

endmodule
