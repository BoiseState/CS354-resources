package shapes

// Triangle like Square, is a struct representing a shape.
type Triangle struct {
	a, b, c int
}

func NewTriangle(x int) (s *Triangle) {
	s = new(Triangle)
	return
}

// Perimeter is defined for Triangle
func (t *Triangle) Perimeter() (p int) {
	p = t.a + t.b + t.c
	return
}

//String() is not defined for Triangle though!
