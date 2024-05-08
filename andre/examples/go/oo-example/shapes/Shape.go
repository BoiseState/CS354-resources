// Package shapes demonstrates very simple interface embedding and fulfillment
package shapes

import "fmt"

// Shaper An interface for a shape. Go convention prefers the interface uses
// a name ending in 'er'
// An embedded interface adds that interface's method
// set to this interface's method set
type Shaper interface {
	fmt.Stringer //embedded interface
	Perimeter() int
}
