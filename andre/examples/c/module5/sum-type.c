#include <stdio.h>

typedef enum {
    CIRCLE,
    RECTANGLE
} ShapeType;

typedef struct {
    ShapeType type;

    union {
        struct {
            double radius;
        } circle;

        struct {
            double width;
            double height;
        } rectangle;
    } data;

} Shape;


double area(Shape s) {
    switch (s.type) {
    case CIRCLE:
        return 3.14159265359 * s.data.circle.radius * s.data.circle.radius;

    case RECTANGLE:
        return s.data.rectangle.width * s.data.rectangle.height;
    }

    return 0.0;
}

int main(void) {
    Shape c = {
        .type = CIRCLE,
        .data.circle = { .radius = 2.0 }
    };

    Shape r = {
        .type = RECTANGLE,
        .data.rectangle = { .width = 2.0, .height = 4.0 }
    };

    printf("%f\n", area(c));
    printf("%f\n", area(r));
    return 0;
}