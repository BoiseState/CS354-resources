module Clk#(Div='d0)(input Base, output reg Gen);

   localparam width=$clog2(Div+1);
   localparam [width:0]one=1;
   reg [width:0]cnt;

   initial begin
      Gen<=0;
      cnt<=Div[width:0];
   end

   // If Div is zero this divides Base by two.
   // Else, see below.
   always @ (posedge Base)
     if (|cnt) cnt<=cnt-one;
     else begin Gen<=~Gen; cnt<=Div[width:0]; end

endmodule

// Div pd p/2  MHz
// --- -- --- ----
//   -  2   1 66.0
//   0  4   2 33.0
//   1  8   4 16.5
//   2 12   6 11.0
//   3 16   8  8.2
//   4 20  10  6.6
//   5 24  12  5.5
//   6 28  14  4.7
//   7 32  16  4.1
//   8 36  18  3.7
//   9 40  20  3.3
//  10 44  22  3.0
