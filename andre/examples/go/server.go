package main

import (
	"fmt" 
	"log"
	"net/http"
)

func main() {
	http.HandleFunc("/", handler)
	log.Fatal(http.ListenAndServe("localhost:3000", nil))
}

// FIXME in Class
func handler(w http.ResponseWriter, r *http.Request) {
	_, err := fmt.Fprintf(w, "URL.Path = %q\n", r.URL.Path)

	if err != nil {
		// do something
	}
}