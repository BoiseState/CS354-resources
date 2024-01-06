#include <stdio.h>

//unsigned arguments?
int multiply(unsigned int op1, unsigned int op2)
{
    int mask = 0x1;
    int accumulator = 0;

        while(op2) {
            if(mask & op2) {
                accumulator += op1;
            }
            op1 = op1 << 1;
            //if op2 is negative and not defined as unsigned, right shifting shifts 1's into it.
            op2 = op2 >> 1;

            //Try printing the value of op2, to see how this works.
            //printf("%d:\t0x%x\n", op2, op2);
        }

    return accumulator;
}

int main() {

    printf("%d\n", multiply(-1, -15));
    return 0;
}