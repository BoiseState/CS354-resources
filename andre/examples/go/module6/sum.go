package main

import "fmt"

// recursive slice sum. Not tail recursive
func sum(items []int) int {

	if len(items) == 0 {
		return 0
	}

	return items[0] + sum(items[1:])

}

// sumTail uses a tail call
func sumTail(items []int, acc int) int {

	if len(items) == 0 {
		return acc
	}
	// items becomes items[1:], acc becomes acc + items[0]
	return sumTail(items[1:], acc+items[0])

}

// sumIter eliminates the tailcall
func sumIter(items []int, acc int) int {
	for !(len(items) == 0) {

		// items becomes items[1:], acc becomes acc + items[0]
		acc = acc + items[0]
		items = items[1:]
	}
	return acc
}

func main() {
	numbers := []int{1, 2, 3, 4, 5}
	fmt.Println(sum(numbers))
	fmt.Println(sumTail(numbers, 0))
	fmt.Println(sumIter(numbers, 0))
}
