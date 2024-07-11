package main

import "fmt"

func multiply(a int, b int) int {

    mask := 0x1
    accumulator := 0

    for b != 0 {
        if mask & b == 0x1 {
            accumulator += a
        }

        a = a << 1
        //signed right shifts cause negative numbers to not work
        //Go chose to make the shift behavior depend on whether the shiftee is signed or not
        //In other words, no >>> operator like in Java
        b = int(uint(b) >> 1)

        //uncomment this to learn a bit more about how this works
        //fmt.Printf("%d:\t0x%x\n", b, b);
    }

    return accumulator

}


func main() {
    fmt.Printf("3 * 6 = %d\n", multiply(3, 6))
    fmt.Printf("-3 * 6 = %d\n", multiply(-3, 6))
    fmt.Printf("3 * -6 = %d\n", multiply(3, -6))
    fmt.Printf("1353 * 4799 = %d\n", multiply(1353, 4799))
}