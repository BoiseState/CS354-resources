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

	_, err = file.WriteString("Hello, world!\n")
	if err != nil {
		fmt.Println("Write error:", err)
		err := file.Close()
		if err != nil {
			return
		}
		return
	}

	err = file.Close()
	if err != nil {
		fmt.Println("Close error:", err)
		return
	}
}
