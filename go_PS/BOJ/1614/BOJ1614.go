package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
)

func main() {
	defer w.Flush()
	var n int
	fmt.Fscanln(r, &n)
	var m int
	fmt.Fscanln(r, &m)
	if n == 1 {
		fmt.Fprintln(w, 8*m)
	} else if n == 5 {
		fmt.Fprintln(w, 4+8*m)
	} else {
		if m%2 == 0 {
			fmt.Fprintln(w, 8*(m/2)+n-1)
		} else {
			fmt.Fprintln(w, 8*((m+1)/2)-(n-1))
		}
	}
}
