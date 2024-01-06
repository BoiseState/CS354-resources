package main

import "fmt"

func getAddr() *int {
	v := 1
	return &v
}

func incr(p *int) int {
	*p++
	return *p
}

func main() {
	//basics
	x := 1
	p := &x
	fmt.Println(*p)
	*p = 2
	fmt.Println(x)

	//addresses of local variables?
	fmt.Println(getAddr() == getAddr())

	local := 1
	incr(&local)
	fmt.Println(incr(&local))

	//check echo4.go!
}
