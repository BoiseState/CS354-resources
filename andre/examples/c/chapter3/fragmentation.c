//demonstrates external heap fragmentation
#include <stdlib.h>
#include <stdio.h>

int main() {

    char *a = malloc(17);
    char *b = malloc(4);
    char *c = malloc(17);

    free(b);
    char *d = malloc(32); //too big for b's space

    printf("a is at\t %p\n", a);
    printf("b was at %p\n", b);
    printf("c is at\t %p\n", c);
    printf("d is at\t %p\n", d);
}