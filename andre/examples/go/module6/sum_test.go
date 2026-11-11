package main

import (
	"math/rand"
	"testing"
)

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
	return sumTail(items[1:], acc + items[0])

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

func fillSlice(n int) []int {
	ints := make([]int, n)
	for i, _ := range ints {
		ints[i] = rand.Int()
	}
	return ints
}

func BenchmarkSumRec(b *testing.B) {
	ints := fillSlice(1000)
	for i := 0; i < b.N; i++ {
		sum(ints)
	}
}

func BenchmarkSumTail(b *testing.B) {
	ints := fillSlice(1000)
	for i := 0; i < b.N; i++ {
		sumTail(ints, 0)
	}
}


func BenchmarkSumIter(b *testing.B) {
	ints := fillSlice(1000)
	for i := 0; i < b.N; i++ {
		sumIter(ints, 0)
	}
}
