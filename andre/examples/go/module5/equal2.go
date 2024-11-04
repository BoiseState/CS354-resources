package main

import "fmt"

type A struct {
	x int
	y int
}

type B struct {
	x int
	y int
}

// refer to equal2.c
func main() {

	myB := B{ x: 1, y: 2}

	// castB is a pointer of type A that points to B.
	// Can we use a type B like a type A?
	var castB *A = (*A)(&myB)

	fmt.Printf("castB.x = %d\n", castB.x);
}