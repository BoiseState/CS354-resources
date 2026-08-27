// a simple program that demonstrates interfaces and struct embedding
package main

//package main contains an executable.
//Sometimes, it is conventional to put executables under a cmd/ directory

//importing a package from the std lib and our own package.
import (
	"fmt"
	"github.com/BoiseState/CS354-resources/tree/master/andre/examples/go/oo-example/optometry"
	"github.com/BoiseState/CS354-resources/tree/master/andre/examples/go/oo-example/shapes"
)

func main() {
	//type inference is not used so that we can specify the type of s1 as Shape
	var s1 shapes.Shape = shapes.NewSquare(4)

	fmt.Println(s1.String())

	var s2 shapes.Shape = shapes.NewRightTriangle(1, 2, 3)

	fmt.Println(s2) //implements the Stringer interface, don't need to call String()

	//var s3 shapes.Shape = shapes.Triangle{1, 2, 3} //this is illegal!
	// A Triangle doesn't fulfill the method set for shapes.Shape

	//Uh, this definitely isn't a shape...
	var s3 shapes.Shape = optometry.NewEye()

	fmt.Println(s3)
	fmt.Println(s3.Perimeter())
}
