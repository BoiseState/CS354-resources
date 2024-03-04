#include <stdio.h>

void b() {
    int a = 2;
    goto LBL;
    {
        int a = 1;
LBL:
        printf("%d\n", a);
    }
}

int main() {
    b();
}