package main

import "fmt"

type Person struct {
	age  int32
	name string
}

func inc_age(p Person) {

	p.age = p.age + 1
}

func inc_age_pointer(p *Person) {

	p.age = p.age + 1
}

func main() {

	var p *Person = new(Person)

	p.age = 40
	p.name = "myname!"

	fmt.Println(p.age)

	inc_age(*p)

	fmt.Println(p.age)

	inc_age_pointer(p)

	fmt.Println(p.age)
}
