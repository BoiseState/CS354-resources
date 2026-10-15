package main

import "fmt"

func sum(ints ...int) int {
	var sum int
	for _, in := range ints {
		sum += in
	}
	return sum
}

func main() {
	numbers := []int{1, 2, 3, 4, 5}
	result := sum(numbers...)
	fmt.Println(result)
}
