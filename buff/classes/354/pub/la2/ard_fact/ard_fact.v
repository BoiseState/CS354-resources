module ard_fact#(BITS='d4, WORDS='d1)(
    input CLK66, input INIT,
    output BusEna[3:1],         // EPT<->ARD bus enable(low)
    output BusDir[3:1],         // EPT<->ARD bus direction
    inout [BITS-1:0]ARDbus,     // EPT<->ARD bus
    input ARDrd, output ARDwr,  // EPT<->ARD bus ctl
    input SWS[2:1], output [2:0]LEDS[4:1], output LA[15:0]);

   wire ardInpEn, ardInpOk;
   wire ardOutEn, ardOutOk;
   wire [BITS-1:0]ardInp,    // word data read: ARD -> EPT
                  ardOut;    // word data writ: EPT -> ARD

   wire [WORDS*BITS-1:0]inp, // aggregate data read: ARD -> EPT
                        out; // aggregate data writ: EPT -> ARD
   wire fn_ie, fn_oe;        // input/output enable

   // divide_by 10 => 150ns period => 6.6MHz
   reg CLK; Clk#(.Div('d4)) clk(.Base(CLK66), .Gen(CLK)); // 6.6MHz (24 bits)

   wire [2:0]leds[3:1];
   assign LEDS[3]=leds[3], LEDS[2]=leds[2], LEDS[1]=leds[1];

   wire Init, Rd, Wr;
   Sync sync_init(CLK,INIT,Init);
   Sync sync_read(CLK,ARDrd,Rd);
   assign ARDwr=Wr;

   BiDiBus#(.BITS(BITS))
         bus(.CLK, .INIT(Init),
             .BusEna,                            // EPT<->ARD bus enable(low)
             .BusDir,                            // EPT<->ARD bus direction
             .ARDbus,                            // EPT<->ARD
             .Rd, .Wr,                           // EPT<->ARD bus ctl
             .OutEn(ardOutEn), .OutOk(ardOutOk), // EPT<--ARD bus output enable/ready
             .InpEn(ardInpEn), .InpOk(ardInpOk), // EPT-->ARD bus input enable/ready
             .Out(ardOut),                       // EPT<--ARD bus input/output
             .Inp(ardInp),                       // EPT-->ARD bus input/output
             .SWS, .LED(LEDS[4]), .LA);

   ard_io#(.BITS(BITS), .WORDS(WORDS))
          io(.CLK, .INIT(Init),
             .ARDOutEn(ardOutEn), .ARDOutOk(ardOutOk), // EPT<--ARD bus output enable/ready
             .ARDInpEn(ardInpEn), .ARDInpOk(ardInpOk), // EPT-->ARD bus input enable/ready
             .ARDOut(ardOut),                          // word I/O from ARD
             .ARDInp(ardInp),                          // word I/O to ARD
             .Inp(inp),                                // aggregate input from ARD 
             .Out(out),                                // aggregate output to ARD
             .IE(fn_oe),
             .OE(fn_ie),
             .SWS, .LEDS(leds));

   Factorial#(.BITS(BITS*WORDS))
        fact(.CLK,
             .INP(inp), .IE(fn_ie),
             .OUT(out), .OE(fn_oe));

endmodule
