#include <stdio.h>

void f(void) {
    static int a = 0; // automatically allocated variable on the stack
    printf("a = %d\n", a);
    printf("&a = %p\n", &a);

    a++;
}

int main(void) {

    f();
    f();
    f();

    return 0;
}