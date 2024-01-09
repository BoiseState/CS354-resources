#include <stdio.h> 

//doesn't work
void power (int inp, int n) 
{
    int base = inp;

    while (n >= 1) {
        inp = inp * base;
        n--;
    }
}

//try this!
void power_pointer(int *pInp, int n)
{
    int base = *pInp;
    while (n > 1) {
        *pInp = *pInp * base;
        n--;
    }
}

//best!
int power_ret(int inp, int n) 
{
    int p = inp;
    for (p = 1; n > 0; --n)
        p = p * inp;
    
    return p;
}


int main()
{
    int num = 4;

    power(num, 4);

    printf("%d\n", num);

    power_pointer(&num, 4);

    printf("%d\n", num);

    printf("%d\n", power_ret(4, 4));

    return 0;
}
