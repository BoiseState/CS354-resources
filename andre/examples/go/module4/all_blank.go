package main

import "fmt"

func main() {
	var A [][]int
	var i,j int
	var n int


	first_zero_row := -1;        /* none */
outer: for i = 0; i < n; i++ {
		for j = 0; j < n; j++ {
			if (A[i][j] != 0) {
				continue outer
			};
		}
		first_zero_row = i;
		break;
	}

	fmt.Printf("first all zero row is %d\n", first_zero_row)
}