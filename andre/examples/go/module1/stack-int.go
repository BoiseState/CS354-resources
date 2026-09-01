package main

type StackInt struct {
	a []int
}

func NewInt() *StackInt {
	return &StackInt{
		a: make([]int, 0),
	}
}

func (s *StackInt) Peek() (e int, avail bool) {
	if len(s.a) == 0 {
		return e, false
	}
	return s.a[len(s.a)-1], true
}

func (s *StackInt) Pop() (e int, avail bool) {
	if len(s.a) == 0 {
		return e, false
	}
	e = s.a[len(s.a)-1]
	s.a = s.a[:len(s.a)-1]
	return e, true
}

func (s *StackInt) Push(e int) {
	s.a = append(s.a, e)
}

func (s *StackInt) Empty() bool {
	return len(s.a) == 0
}

