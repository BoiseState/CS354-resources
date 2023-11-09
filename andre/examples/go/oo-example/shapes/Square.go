package shapes

import "fmt"

type ISquare interface {
	IShape
}

type Square struct {
	x int32
}

func CreateNewSquare(x int32) (s *Square) {
	s = new(Square)
	s.Init(x)
	return
}

func (s *Square) Init(x int32) {
	s.x = x
}

func (s *Square) Area() (a float64) {
	a = float64(s.x * s.x)
	return
}

func (s *Square) String() string {
	return fmt.Sprintf("Square, side length: %d\n", s.x)
}
