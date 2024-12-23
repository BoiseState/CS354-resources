package main

import (
	"fmt"
	"math/rand"
	"sync"
	"time"
)

// go's philosophy on multithreading is “Do not communicate by sharing memory; instead, share memory by communicating.”
// go provides the programmer channels for the purpose of communication.

func ping(ch chan int) {
	for i := range ch {
		fmt.Printf("received ping: %d\n", i)
		if i > 0 {
			time.Sleep(time.Duration(rand.Intn(100)) * time.Millisecond)
			ch <- i - 1
		} else {
			close(ch)
		}
	}
}

func pong(ch chan int) {
	for i := range ch {
		fmt.Printf("\treceived pong: %d\n", i)
		if i > 0 {
			time.Sleep(time.Duration(rand.Intn(1000)) * time.Millisecond)
			ch <- i - 1
		} else {
			close(ch)
		}
	}
}

func main() {
	ch := make(chan int,10)
	var wg sync.WaitGroup

	wg.Add(2)

	go func() {
		defer wg.Done()
		ping(ch)
	}()
	go func() {
		defer wg.Done()
		pong(ch)
	}()
	ch <- 100 //send a value to the channel

	wg.Wait()

}