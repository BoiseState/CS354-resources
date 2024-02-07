package main

import "fmt"

var a int

func first() {
	a = 1
}

func second() {
	var a int
	dummy(a) //can't compile without using a
	first()
}

func main() {
	a = 2
	second()
	fmt.Println(a)
}

func dummy(a int) {

}
