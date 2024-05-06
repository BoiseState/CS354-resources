package shapes

import "fmt"

type Square struct {
	x int32
}

func NewSquare(x int32) (s *Square) {
	s = new(Square)
	return
	/*alternatively:
	return &Square{x: x}
	*/
}

func (s *Square) Area() (a float64) {
	a = float64(s.x * s.x)
	return
}

func (s *Square) String() string {
	return fmt.Sprintf("Square, side length: %d\n", s.x)
}
