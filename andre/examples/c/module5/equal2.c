#include <stdio.h>


typedef struct {
    int x;
    int y;
} A;

typedef struct {
    int x;
    int y;
} B;


int main() {

    B myB = {x: 1, y: 2};

    // castB is a pointer of type A that points to B.
    // Can we use a type B like a type A?
    A *castB = (A *)&myB;

    printf("castB->x = %d\n", castB->x);

    return 0;
}