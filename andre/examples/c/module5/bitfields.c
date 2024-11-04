#include <stdio.h>


typedef union {
  double d;
  struct {
    // IEEE 754 double-precision binary floating-point format: binary64
    unsigned long int fraction:52;
    unsigned int exponent:11;     	// of two, not ten
    unsigned int sign:1;
  } bits;
} IEEE754;


int main(void) {
    IEEE754 value;
    value.d=3.14159;			//set the double field to a double
    value.bits.exponent++;		//access the exponent field of it.
    value.bits.sign^=1;			//access the sign field of it
    printf("value.d: %g\n",value.d);

    value.d=-3.012;
    printf("value.bits.sign: %x, value.bits.exponent: %x, value.bits.fraction: %lx\n",
                               value.bits.sign, value.bits.exponent, value.bits.fraction); // print the components of it

    return 0;
}
