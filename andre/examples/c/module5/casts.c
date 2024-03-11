#include <stdio.h>

int main() {

    int a = 4;
    float b = 15.1;

    int *pa = &a;
    float *pb = (float *) pa;

    printf("structural equal cast: %g\n", *pb);

    short unsigned int ui = 65536;
    short int i = (short int) ui;

    printf("shared set cast: %d\n", i);

    printf("different bit representation cast: %d\n", (int) b);

}