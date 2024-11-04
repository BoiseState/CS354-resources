package main

import "fmt"

func testDefer() {
	i := 0
	defer fmt.Printf("testDefer: %d\n", i)
	i++
	return
}

func testDeferStack() {

	for i := 0; i < 4; i++ {
		defer fmt.Println(i)
	}
}

func f() {
	defer func() {
		if r := recover(); r != nil {
			fmt.Println("Recovered in f", r)
		}
	}()
	fmt.Println("Calling g.")
	g(0)
	fmt.Println("Returned normally from g.")
}

func g(i int) {
	if i > 3 {
		fmt.Println("Panicking!")
		panic(fmt.Sprintf("%v", i))
	}
	defer fmt.Println("Defer in g", i)
	fmt.Println("Printing in g", i)
	g(i + 1)
}

func main() {
	//testDefer()
	//testDeferStack()

	f()
	fmt.Println("Returned normally from f.")

}
