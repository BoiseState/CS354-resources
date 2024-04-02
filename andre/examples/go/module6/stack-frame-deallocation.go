// demonstration that a compiler should choose where var declarations exist
package main

import "fmt"

var global *int32

func f() {
	var x int32 = 12
	global = &x //x must live on

}

func g() int32 {
	var y int32 = 13
	return y
}

func main() {

	f()
	fmt.Printf("globals value:\t%d\nglobals ptr:\t%p\nglobals\taddress %p\n", *global, global, &global)
	g()
	fmt.Printf("globals value:\t%d\n", *global)
}
