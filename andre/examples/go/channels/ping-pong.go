package main

import (
	"fmt"
	"time"
)

// go's philosophy on multithreading is “Do not communicate by sharing memory; instead, share memory by communicating.”
// go provides the programmer channels for the purpose of communication.

func ping(ch chan int) {
	var n int
	for ok := true; ok; ok = n>0 {
		n = <- ch
		fmt.Printf("received ping: %d\n", n)
		ch <- n - 1
	}
}

func pong(ch chan int) {
	var n int
	for ok := true; ok; ok = n>0 {
		n := <- ch
		fmt.Printf("received pong: %d\n", n)
		ch <- n - 1
	}
}

func main() {
	ch := make(chan int)

	go ping(ch)
	go pong(ch)
	ch <- 10 //send a value to the channel

	time.Sleep(60 * time.Second)

}