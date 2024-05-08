package optometry

type Eye struct {
	color string
}

func NewEye() *Eye {
	return &Eye{color: "blue"}
}

// Perimeter is the systematic measurement of the visual field
func (*Eye) Perimeter() int {
	return 90 //90 degrees
}

func (e *Eye) String() string {
	return "I am at the eye doctor!"
}
