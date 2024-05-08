package shapes

import "fmt"

// RightTriangle is a struct with an anonymous embedded struct inside of it
type RightTriangle struct {
	Triangle //the triangle struct
}

// NewRightTriangle creates a new RightTriangle, which contains a Triangle
func NewRightTriangle(a, b, c int) (t *RightTriangle) {
	return &RightTriangle{
		Triangle{
			a: a,
			b: b,
			c: c,
		},
	}
}

// String finally provided here. Perimeter is 'inherited' by the embedded struct!
func (t *RightTriangle) String() string {
	return fmt.Sprintf("Right Triangle with perimeter %d\n", t.Perimeter())
}
