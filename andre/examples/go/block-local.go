package main

import "fmt"

func main() {
	var x int32 = 1
	var y int32 = 4
	fmt.Printf("x: %p\n", &x)
	fmt.Printf("y: %p\n", &y)

	{
		var x int32 = 2
		var y int32 = 5
		fmt.Printf("x: %p\n", &x)
		fmt.Printf("y: %p\n", &y)
	}
	{
		var x int32 = 3
		var y int32 = 6
		fmt.Printf("x: %p\n", &x)
		fmt.Printf("y: %p\n", &y)
	}
}
