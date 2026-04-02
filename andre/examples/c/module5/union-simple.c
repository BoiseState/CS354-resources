#include <stdio.h>

int main(void) {
    union U {
        int x;
        long y;
        char c;
    };

    printf("sizeof union U is %lu\n", sizeof(union U));

    return 0;
}