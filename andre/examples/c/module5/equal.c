#include <stdio.h>


typedef struct {
    int x, y;
} A;

typedef struct {
    int x, y;
} B;

void test(A a) {

    printf("a.x = %d\n", a.x);
    return;
}

int main() {

    B myB = {x: 1, y: 2};

    // A and B have the same internal structure. Can I use one for the other?
    test(myB);
    return 0;
}