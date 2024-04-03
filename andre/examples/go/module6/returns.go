package main

import "fmt"

func returns() (a int32, b int32) {
	a, b = 12, 13
	return
}

func main() {
	fmt.Println(returns())
}
