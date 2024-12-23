package main

import (
	"fmt"
	"time"
)

func printer(ch chan string) {
	for s := range ch {
		fmt.Printf("%s", s)
		time.Sleep(time.Second)
	}
}

func main() {
	ch := make(chan string)

	go printer(ch)

	ch <- "hello,"
	ch <- " world!"
	close(ch)
	time.Sleep(10 * time.Second)
}