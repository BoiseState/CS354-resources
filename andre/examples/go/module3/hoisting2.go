package main

import "fmt"

var a = 1;


func test() {
	fmt.Println(a);

	var a = 2;

	fmt.Println(a);
}

func main() {
	test();
}