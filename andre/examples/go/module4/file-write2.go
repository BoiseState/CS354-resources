package main

import (
	"fmt"
	"os"
)

func main() {
	file, err := os.Create("output.txt")
	if err != nil {
		fmt.Println("Open error:", err)
		return
	}
	defer file.Close() // try to wrap in closure

	_, err = file.WriteString("Hello, world!\n")
	if err != nil {
		fmt.Println("Write error:", err)
		err := file.Close()
		if err != nil {
			return 
		}
		return
	}
}
