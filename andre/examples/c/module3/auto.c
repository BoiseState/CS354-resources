#include <stdio.h>

void f(void) {
    auto int a = 10; // automatically allocated variable on the stack
    printf("a = %d\n", a);
    printf("&a = %p\n", &a);
}

int main(void) {

    f();
    // repeated calls use the same stack space
    f();
    f();

    return 0;
}