package main

import "fmt"

func a(ch chan int) {
	a, b := 0, 1
	for {
		ch <- a
		a = a + b
		b = b + 1
	}
}

func main() {
	ch := make(chan int)
	go a(ch)
	for i := 0; i < 10; i++ {
		fmt.Println(<-ch)
	}
}
