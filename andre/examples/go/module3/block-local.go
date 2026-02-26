package main

import "fmt"

func main() {
	var x int32 = 1
	var y int32 = 4

	{
		var x int32 = 2
		y = 5
		fmt.Printf("x = %d, y = %d\n", x, y)
	}

	fmt.Printf("x = %d, y = %d\n", x, y)
}
