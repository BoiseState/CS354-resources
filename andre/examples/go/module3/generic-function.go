package main

import "fmt"

// neat function!
func asSliceInts(ints... int) []int{
	slice := make([]int, 0)
	for _, i := range ints {
		slice = append(slice, i)
	}

	return slice
}

// even better
func asSlice[T any](objs... T) []T {
	slice := make([]T, 0)
	for _, i := range objs {
		slice = append(slice, i)
	}

	return slice

}

func main() {
	mySlice := asSliceInts(1, 2, 3, 4, 5)

	fmt.Println(mySlice)

	stringSlice := asSlice[string]("a", "b", "c")
	//stringSlice := asSlice("a", "b", "c") // the type parameter can be inferred

	fmt.Println(stringSlice)
}