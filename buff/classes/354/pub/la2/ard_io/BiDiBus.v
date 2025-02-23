module BiDiBus#(BITS='d4)(
    input CLK, input INIT,
    output BusEna[3:1],     // EPT<->ARD bus enable(low)
    output BusDir[3:1],     // EPT<->ARD bus direction
    inout [BITS-1:0]ARDbus, // EPT<->ARD I/O bus
    input Rd,               // ARDrd, from ARD
    output reg Wr,          // ARDwr, to ARD
    input OutEn,            // EPT<--ARD bus output enable
    output reg OutOk,       // EPT<--ARD bus output ready
    input InpEn,            // EPT-->ARD bus input enable
    output reg InpOk,       // EPT-->ARD bus input ready
    input [BITS-1:0]Inp,    // EPT-->ARD bus input
    output [BITS-1:0]Out,   // EPT<--ARD bus output
    input SWS[2:1], output reg [2:0]LED, output LA[15:0]);

   assign BusEna[1]=0, BusEna[2]=0, BusEna[3]=0; // ARD<->EPT bus enable(low)

   localparam bit dirOut=0, dirInp=1;
   reg dir;                     // bus direction
   assign BusDir[1]=dir;
   assign BusDir[2]=dirOut;     // bus 2 always output (EPT->ARD)
   assign BusDir[3]=dirInp;     // bus 3 always input (ARD->EPT)

   assign ARDbus=(dir==dirOut ? Inp : 'z); // data to ard; our input

   wire [BITS-1:0]Bus;
   Sync#(.BITS(BITS)) sync_bus(CLK,ARDbus,Bus);

   reg [BITS-1:0]out;
   assign Out=out;              // data from ard; our output

`include "led"

   typedef enum {StINIT,
                 StRD1,StRD2,StRD3,StRD4,
                 StWR1,StWR2,StWR3} State;
   State curr, next;

   initial begin
      dir=dirOut;               // default bus direction
      Wr=0;
      OutOk=0;
      InpOk=0;
      curr<=StINIT;
      next<=StINIT;
   end

   always @(posedge CLK or posedge INIT)
     if (INIT) curr<=StINIT;
     else      curr<=next;

   always @* begin #2;
      LED=lOFF;
      dir=dirOut;           // default bus direction
      Wr=0;
      OutOk=0;
      InpOk=0;
      next=StINIT;
      case (curr)
        StINIT: begin LED=lRED;		    // 0:
           if (!InpEn && OutEn) next=StRD1; // read data from ard
           if (InpEn && !OutEn) next=StWR1; // write data to ard
        end

         // *** READ DATA FROM ARD ***
        StRD1: begin LED=lBLU;	// 1: EPT<--ARD
           dir=dirInp;		// switch bus direction
           if (Rd) next=StRD2;
	   else    next=StRD1;
	end
        StRD2: begin LED=lMAG;	// 2: Wait for ARD to write data.
           dir=dirInp;		// switch bus direction
           Wr=1;		// we say "we're ready"
           if (!Rd) next=StRD3;
	   else     next=StRD2;
	end
        StRD3: begin		// 3: Read it.
           dir=dirInp;		// switch bus direction
           Wr=1;
	   OutOk=1;
           next=StRD4;
        end
        StRD4: begin LED=lYEL;	// 4: Wait for EPT.
	   OutOk=1;
           if (!OutEn) next=StINIT;
	   else        next=StRD4;
	end

         // *** WRITE DATA TO ARD ***
        StWR1: begin LED=lGRN;	// 5: EPT-->ARD
           if (Rd) next=StWR2;
	   else    next=StWR1;
	end
        StWR2: begin LED=lYEL;	// 6: Wait for ARD to read data.
           Wr=1;		// we say "read it"
           if (!Rd) next=StWR3;
	   else     next=StWR2;
	end
        StWR3: begin LED=lWHT;	// 7: Wait for EPT.
	   InpOk=1;
           if (!InpEn) next=StINIT;
	   else        next=StWR3;
	end
      endcase
   end

   always @(posedge CLK)
     case (curr)
       StRD3: out<=Bus;		// data from ard
     endcase

   assign LA[0]=1;
   assign LA[1]=CLK;
   assign LA[2]=Rd;
   assign LA[3]=Wr;
   assign LA[4]=(dir==dirOut ? Inp[0] : Out[0]);
   assign LA[5]=(dir==dirOut ? Inp[1] : Out[1]);
   assign LA[6]=(dir==dirOut ? Inp[2] : Out[2]);
   assign LA[7]=(dir==dirOut ? Inp[3] : Out[3]);

endmodule
