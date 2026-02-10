package main

import "fmt"

var a int

func modify() {
	a = 2
}

func initialize() {
	var a int
	dummy(a) //can't compile without using a
	modify()
}

func main() {
	a = 1
	initialize()
	fmt.Println(a)
}

func dummy(a int) {

}
