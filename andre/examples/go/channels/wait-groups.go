package main

import (
	"fmt"
	"sync"
	"time"
)

func printer2(ch chan string) {
	for s := range ch {
		fmt.Printf("%s", s)
		time.Sleep(time.Second)
	}
}
func printer(ch chan string, wg *sync.WaitGroup) {
	for s := range ch {
		fmt.Printf("%s", s)
		time.Sleep(time.Second)
	}
	wg.Done()
}

func main() {
	ch := make(chan string)
	var wg sync.WaitGroup

	// tell the wg that there is a new thread to wait for
	wg.Add(1)
	// method one, pass a reference to the waitgroup
	go printer(ch, &wg)

	ch <- "hello,"
	ch <- " world!"
	close(ch)

	// create a new channel
	ch = make(chan string)

	wg.Add(1)
	// method two, use an anonymous function with defer
	go func() {
		defer wg.Done()
		printer2(ch)
	}()


	ch <- "goodbye,"
	ch <- " world!"
	close(ch)
}