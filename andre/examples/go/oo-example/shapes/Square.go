package shapes

import "fmt"

// Square a struct that represents a square
type Square struct {
	x int //lowercase field cannot be accessed outside of this module
}

// NewSquare function that creates a new square
func NewSquare(x int) (s *Square) {
	s = new(Square)
	s.x = x
	return
	/*
		alternatively:
		return &Square{x: x}
	*/
}

// Perimeter reports the perimeter of this shape. The (s *Square) is the
// receiver of this method
// Additionally, the return value is named in the function signature!
func (s *Square) Perimeter() (p int) {
	p = s.x * 4
	return
}

// String is required by the fmt.Stringer interface
func (s *Square) String() string {
	return fmt.Sprintf("Square, side length: %d\n", s.x)
}
