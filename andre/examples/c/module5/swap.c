#include <stdio.h>

typedef union {
    int x;
    struct {
        char a;
        char b;
        char c;
        char d;
    } s;
} Int;

void swap(Int *i) {

    char _a = i->s.a;
    char _b = i->s.b;
    char _c = i->s.c;
    char _d = i->s.d;

    //swap the bytes
    i->s.a = _d;
    i->s.b = _c;
    i->s.c = _b;
    i->s.d = _a;

}

int main(void) {

    printf("sizeof Int is %lu\n", sizeof(Int));

    Int i = {x: 0x12345678};

    printf("byte1 = %#x\n", i.s.d);
    printf("byte2 = %#x\n", i.s.c);
    printf("byte3 = %#x\n", i.s.b);
    printf("byte4 = %#x\n", i.s.a);

    swap(&i);

    printf("Int.x swapped is %#x\n", i.x);

    return 0;
}