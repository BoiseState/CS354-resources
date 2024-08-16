// Verilog sum program

module sum();

   reg [31:0]seq[5:0];
   assign seq[0]=5;
   assign seq[1]=6;
   assign seq[2]=1;
   assign seq[3]=8;
   assign seq[4]=3;
   assign seq[5]=7;

   reg [31:0]s=0;
   integer i;

   initial begin
      for (i=0; i<=5; i++)
	 s=s+seq[i];
      $display("%d",s);
      $stop;
   end

endmodule
