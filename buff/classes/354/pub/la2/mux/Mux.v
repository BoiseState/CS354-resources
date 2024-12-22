module Multiplexer#(BITS='d32)(
    input CLK,
    input [BITS-1:0]A, B,
    output reg [BITS-1:0]Y,
    input IE,
    output reg OE,
    input SEL);		// 0->A, 1->B

   assign Y=SEL ? B : A;
   assign OE=IE;

endmodule
