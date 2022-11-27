package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r *bufio.Reader
	w *bufio.Writer
)

func init() {
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
}

func main() {
	defer w.Flush()
	var n int
	fmt.Fscanln(r, &n)
	count := 1
	for n != 1 {
		if n%2 == 1 {
			count++
		}
		n /= 2
	}
	fmt.Fprintln(w, count)
}
