package main

type Stack[E any] struct {
	a []E
}

func New[E any]() *Stack[E] {
	return &Stack[E]{
		a: make([]E, 0),
	}
}

func (s *Stack[E]) Peek() (e E, avail bool) {
	if len(s.a) == 0 {
		return e, false
	}
	return s.a[len(s.a)-1], true
}

func (s *Stack[E]) Pop() (e E, avail bool) {
	if len(s.a) == 0 {
		return e, false
	}
	e = s.a[len(s.a)-1]
	s.a = s.a[:len(s.a)-1]
	return e, true
}

func (s *Stack[E]) Push(e E) {
	s.a = append(s.a, e)
}

func (s *Stack[E]) Empty() bool {
	return len(s.a) == 0
}

