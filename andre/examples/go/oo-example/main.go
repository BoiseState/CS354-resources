// package main is located in the cmd folder by convention
package main

import "github.com/BoiseState/CS354-resources/tree/master/andre/examples/go/oo-example"

func main() {
	var s1 shapes.IShape = shapes.NewSquare(4)

	fmt.Println(s1.String())
}
