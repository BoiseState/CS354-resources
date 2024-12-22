module Clk#(Div='d2, Cnt=Div-1)(input Base, output reg Gen);

   localparam width=$clog2(Div);
   localparam [width-1:0]one=1;
   reg [width-1:0]cnt;

   initial begin
      Gen<=0;
      cnt<=Cnt[width-1:0];
   end

   always @ (posedge Base)
     if (|cnt) cnt<=cnt-one;
     else begin Gen<=~Gen; cnt<=Cnt[width-1:0]; end

endmodule
