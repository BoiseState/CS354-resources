module Store#(BITS=32, FIRST=0)(
    input CLK,
    input [BITS-1:0]INP,
    output reg [BITS-1:0]OUT,
    input IE,
    output reg OE,
    input INIT);

   reg ie;

   initial begin
      OE<=0;
      ie<=0;
   end

   always @ (posedge CLK) begin
      if (IE && !ie) begin
	 OUT<=(INIT ? FIRST : INP);
	 OE<=1;
	 ie<=1;
      end
      if (!IE && ie) begin
	 OE<=0;
	 ie<=0;
      end
   end
      
endmodule
