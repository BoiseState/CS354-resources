// demonstration that a compiler should choose where var declarations exist
// see stack-frame-deallocation.c for C's behavior (hint, its awesome!)
package main

var global *int32

// We've seen this before put x as a local var on the stack
func f() {
	var x int32 = 12
	global = &x //x cannot be deallocated from the stack now, because a global refers to it

}

func g() {
	y := new(int32) //calling malloc() in C would put this on the heap
	*y = 32

}

func main() {
	f()
	g()
}
