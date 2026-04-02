package main

import (
	"fmt"
	"math/rand"
)

// report the first occurrence of 1 in each slice
func report(slice [][]int) {
	outer:
	for i := 0; i < len(slice); i++ {
			for j := 0; j < len(slice[i]); j++ {
				if slice[i][j] == 1 {
					fmt.Printf("1 found at [%d][%d]\n", i, j)
					continue outer
				}
				continue // redundant but demonstrates flow moving to either loop
			}
	}
}

func main() {
	// init 2d slice
	slice := makeSlice(5)
	populateSlice(slice)

	report(slice)
}

func makeSlice(n int) [][]int {
	slice := make([][]int, n)
	for i, _ := range slice {
		slice[i] = make([]int, n)
	}
	return slice
}

func populateSlice(slice[][]int) {

	for i, _ := range slice {
		for j, _ := range slice[i] {
			if rand.Int() % 2 == 0 {
				slice[i][j] = 0
			} else {
				slice[i][j] = 1
			}
		}
	}
}