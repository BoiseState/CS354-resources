#include <stdio.h>
#include <stdlib.h>

typedef struct point Point;

struct point {
	int x;
	int y;
};

// Methods may have receivers which are values
void incY(Point p) {
	p.y = p.y + 1;
}


// Methods may have receivers which are pointers
void decY(Point *p) {
	p->y = p->y - 1;
}

void printPoint(Point *p) {
    printf("point @ %p: x: %d, y: %d\n", p, p->x, p->y);
}


int main(void) {

	Point *myPoint1  = (Point *) malloc(sizeof(Point));
	myPoint1->x = 0;
	myPoint1->y = 0;

	Point myPoint2;
	myPoint2.x = 0;
	myPoint2.y = 0;

	// same as this. Ahh, the root of the problem, call by value
	incY(myPoint2);
    incY(*myPoint1);

	decY(myPoint1);		// similar to function pointers with
	printPoint(myPoint1);

	decY(&myPoint2);
	printPoint(&myPoint2);

    return 0;

}