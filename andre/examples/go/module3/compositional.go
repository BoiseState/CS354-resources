package main

import "fmt"

type Animal struct {
	extinct bool
}

func (a Animal) Extinct() bool {
	return a.extinct
}

type Dinosaur struct {
	Animal
}

func main() {
	d := &Dinosaur{Animal{true}}
	fmt.Println(d.Extinct()) // inherited method
}
