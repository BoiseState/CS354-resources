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

func test(a A) {

	fmt.Printf("a.x = %d\n", a.x)
}

// refer to equal.c
func main() {

	var myB B = B{}

	test((A)(myB)) // try test((A)(myB))
}
