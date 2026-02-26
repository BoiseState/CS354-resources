#include <stdio.h>

void f(void) {
    static int a = 0;
    printf("a = %d\n", a);
    //printf("&a = %p\n", &a); // where does it live?

    a++;
}

int main(void) {

    f();
    f();
    f();

    return 0;
}