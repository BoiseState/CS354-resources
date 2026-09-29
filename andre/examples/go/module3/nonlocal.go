package main

import "fmt"

//corresponds to figure 3.5 in PLP IV

func a() {
	x := 1

	b := func() {
		x := 2

		c := func() {
			fmt.Printf("In c. x = %d\n", x)
		}

		d := func() {
			x := 3
			c()
		}
		fmt.Printf("In b. x = %d\n", x)
		d()
	}

	e := func() {
		fmt.Printf("In e. x = %d\n", x)
		b()
	}
	e()
}


func main() {
	a();
}