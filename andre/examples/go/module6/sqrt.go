package main

import "fmt"

func sqrt(x float64) float64 {
	average := func(x float64, y float64) float64 {
		return (x + y) / 2
	}
	abs := func(x float64) float64 {
		if x < 0 {
			return -x

		} else {
			return x
		}
	}
	square := func(x float64) float64 {
		return x * x
	}
	goodEnough := func(guess float64) bool {
		return abs(square(guess)-x) < 0.001
	}
	improve := func(guess float64) float64 {
		return average(guess, (x / guess))
	}
	var sqrtIter func(float642 float64) float64 //non-orthogonal function recursion
	sqrtIter = func(guess float64) float64 {
		if goodEnough(guess) {
			return guess
		} else {
			return sqrtIter(improve(guess))
		}
	}
	return sqrtIter(1.0)
}

func main() {
	fmt.Println(sqrt(9))
}
