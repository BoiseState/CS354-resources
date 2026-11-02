package main

import "fmt"

// designed to demonstrate tail call elimination by the programmer, not the compiler

// gcd of m and n. Credit Euclid, 300 B.C.
// recursive, and could be tail optimized. Go, however, does not.
func gcd(m, n int) int {
	if n == 0 {
		return m
	}
	return gcd(n, m%n)
}

// gcd_iter of m and n.
// tail calls manually eliminated
func gcd_iter (m, n int) int {
	for !(n == 0) {
		// m is n, n is n%m
		m,n = n, m%n
	}
	return m
}

func main() {
	fmt.Println(gcd_iter(81,63))
}