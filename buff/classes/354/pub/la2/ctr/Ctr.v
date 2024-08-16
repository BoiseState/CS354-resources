module Counter#(BITS=32, CLKS=3'd1)(
    input CLK,
    input [BITS-1:0]INP,        // unsigned
    input bit IE,
    output reg [BITS-1:0]OUT,   // unsigned
    output reg OE,
    input bit DECR,		// 0: ++, 1:--
    input [BITS-1:0]STOP,	// OUT<=[INP..STOP] according to DECR
    input bit CE,		// strobe to count
    output reg INIT, DONE);

   localparam one=BITS'(1);	// for decr/incr-ing

   reg [2:0]cnt;		// max OE clocks

   enum {StTEST,StWAIT} state;

   initial begin
      DONE<=1;
   end

   always @ (posedge CLK) begin
      if (IE) begin
	 cnt<=CLKS;
	 INIT<=1;
	 DONE<=0;
	 OUT<=INP;
	 OE<=0;
	 state<=StTEST;
      end else if (!DONE)
	case (state)
	  StTEST: begin
	     if (DECR ? (OUT<STOP || &OUT) : (OUT>STOP)) begin
		DONE<=1;
		OE<=0;
	     end else begin
		OE<=1;
		if (CE) begin
		   INIT<=0;
		   state<=StWAIT;
		end
	     end
	  end
	  StWAIT: begin
	     if (cnt && CE)
	       cnt<=(cnt-3'b1);
	     else
	       OE<=0;
	     if (!CE) begin
		OUT<=(DECR ? OUT-one : OUT+one);
		state<=StTEST;
	     end
	  end
	endcase
   end

endmodule
