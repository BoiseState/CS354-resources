#include <stdio.h>

int main(void) {

    struct S {
        int x;
        long y;
        char c;
    };

    union U {
        int x;
        long y;
        char c;
    };

    printf("sizeof struct S is %lu\n", sizeof(struct S));
    printf("sizeof union U is %lu\n", sizeof(union U));

    struct S s_instance;

    printf("\ns_instance memory address:   %p\n", &s_instance);
    printf("s_instance.x memory address: %p\n", &(s_instance.x));
    printf("s_instance.y memory address: %p\n", &(s_instance.y));
    printf("s_instance.z memory address: %p\n", &(s_instance.c));

    union U u_instance;

    printf("\nu_instance memory address:   %p\n", &u_instance);
    printf("u_instance.x memory address: %p\n", &(u_instance.x));
    printf("u_instance.y memory address: %p\n", &(u_instance.y));
    printf("u_instance.z memory address: %p\n", &(u_instance.c));

    return 0;
}