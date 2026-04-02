#include <stdio.h>

typedef enum {
    CIRCLE,
    SQUARE
} Type;

typedef struct {
    Type t;
    union {
        struct {
            int r; // radius
        } Circle;
        struct {
            int x; //side length
        } Square;
    } u;
} Shape;

double area(Shape s) {
    switch (s.t) {
        case SQUARE:
            return s.u.Square.x * s.u.Square.x;
        case CIRCLE:
            return s.u.Circle.r * s.u.Circle.r * 3.14159;
        default:
            fprintf(stderr, "Error: unrecognized shape\n");
            return -1;
    }
}

int main(void) {
    Shape square = {
        t: SQUARE,
        u: {Square: {x: 5}}
    };


    Shape circle = {
        t: CIRCLE,
        u: {Circle: {r: 3}}
    };

    printf("Area of square is %g\n", area(square));
    printf("Area of circle is %g\n", area(circle)); //same function!

    return 0;
}