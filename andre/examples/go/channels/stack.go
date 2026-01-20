package main

import "fmt"

func stack() (push func(int), pop func() int) {
	ch := make(chan int)
	data := []int{}

	go func() {
		for v := range ch {
			data = append(data, v)
		}
	}()

	push = func(v int) { ch <- v }
	pop = func() int {
		n := len(data) - 1
		v := data[n]
		data = data[:n]
		return v
	}
	return
}

func main() {
	push, pop := stack()

	push(1)
	push(2)
	push(3)

	fmt.Println(pop())
	fmt.Println(pop())
	fmt.Println(pop())
}
