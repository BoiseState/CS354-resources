#include <stdio.h>

int a;

void modify() {
    a = 2;
}

void init() {

    int a;
    modify();
}

int main() {

    a = 1;
    init();
    printf("%d\n", a);

    return 0;
}
