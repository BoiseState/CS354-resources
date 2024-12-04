package main

import "fmt"

type Point struct {
	x int
	y int
}

// Methods may have receivers which do not have a name
func (Point) incX() {
	//no name to refer to :(
}

// Methods may have receivers which are values
func (p Point) incY() {
	p.y = p.y + 1
}


// Methods may have receivers which are pointers
func (p *Point) decY() {
	p.y = p.y - 1
}

func (p *Point) printPoint() {
	fmt.Printf("point @ %p: x: %d, y: %d\n", p, p.x, p.y);
}


func main() {
	// new yields a pointer to an allocation
	var myPoint1 *Point = new(Point)
	myPoint1.x = 0
	myPoint1.y = 0

	var myPoint2 Point = Point {}

	// uses the same access syntax as the pointer version
	myPoint2.x = 0
	myPoint2.y = 0

	myPoint1.incY() // uses the value receiver
	myPoint1.printPoint() // uses the pointer receiver

	myPoint2.incY() // uses the value receiver
	myPoint2.printPoint()

	// same as this. Ahh, the root of the problem, call by value
	Point.incY(myPoint2)
	// Point.incY(myPoint1) // error

	// recall myPoint1 is pointer type
	myPoint1.decY()				// same as (*myPoint1).decY()
	myPoint1.printPoint()		// same as (*myPoint1).printPoint()
	(*Point).decY(myPoint1)		// similar to function pointers with
	(*Point).printPoint(myPoint1)

	// first two are like Java, syntax for the C like expressions
	myPoint2.decY()
	myPoint2.printPoint()
	// second two are like C
	(*Point).decY(&myPoint2)
	(*Point).printPoint(&myPoint2)

}