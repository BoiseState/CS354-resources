package main

import "fmt"

func main() {

	ch := make(chan string, 2) //try with values 1 and 0 too!

	ch <- "hello,"
	ch <- " world!"

	fmt.Printf("%s", <-ch)
	fmt.Printf("%s\n", <-ch)
}