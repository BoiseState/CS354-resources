#include <stdio.h>

int a;

void first() {
    a = 1;
}

void second() {

    int a;
    first();
}

int main() {

    a = 2;
    second();
    printf("%d\n", a);

    return 0;
}
