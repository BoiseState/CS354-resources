package main

import (
	"fmt"
	"unsafe"
)

type aligned_data struct {
	a int32 //4 bytes
	b int8  //1 byte
	c int32 //4 bytes
}

func main() {
	s := new(aligned_data)

	fmt.Printf("Size of the struct is %d\n", unsafe.Sizeof(*s)) //internal heap fragmentation
	fmt.Printf("s.a is at %p\n", &s.a)
	fmt.Printf("s.b is at %p\n", &s.b) //4 bytes used for one byte!
	fmt.Printf("s.c is at %p\n", &s.c)

}
