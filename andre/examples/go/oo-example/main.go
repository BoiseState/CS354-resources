package main

import (
	"fmt"
	a "local/shapes"
)

func main() {

	var s1 a.IShape = a.CreateNewSquare(4)

	fmt.Println(s1.String())

}
