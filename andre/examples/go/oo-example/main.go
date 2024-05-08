// a simple program that demonstrates interfaces and struct embedding
package main

//package main contains an executable.
//Sometimes, it is conventional to put executables under a cmd/ directory

//importing a package from the std lib and our own package.
import (
	"fmt"
	"github.com/BoiseState/CS354-resources/tree/master/andre/examples/go/oo-example/shapes"
)

func main() {
	//type inference is not used so that we can specify the type of s1 as Shaper
	var s1 shapes.Shaper = shapes.NewSquare(4)

	fmt.Println(s1.String())

	var s2 shapes.Shaper = shapes.NewRightTriangle(1, 2, 3)

	fmt.Println(s2)

	//var s3 shapes.Shaper = shapes.Triangle{1, 2, 3} //this is illegal!
	// A Triangle doesn't fullfil the method set for shapes.Shaper
}
