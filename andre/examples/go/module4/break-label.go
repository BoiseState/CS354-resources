package main

import "fmt"

func loopAndSwitch(i int) {
	loop:
	for ; i < 5; i++ {
		switch i {
			case 0: fmt.Println(i)
			case 1: fmt.Println(i)
			case 2: fmt.Println(i)
			case 3: fmt.Println(i)
			case 4: fmt.Println("breaking out of the loop!"); break loop
			default: break
		}
	}
}

func main() {
	loopAndSwitch(0);
}