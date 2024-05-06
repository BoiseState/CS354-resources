// Package shapes demonstrates very simple interface embedding and fulfillment
package shapes

import "fmt"

type IShape interface {
	fmt.Stringer //embedded interface
	Area() float64
}
