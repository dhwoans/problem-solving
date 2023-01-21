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
	ans := n
	for true {
		sum := n/3 + n/5 - n/15
		if n-sum == ans {
			break
		} else {
			n++
		}
	}
	fmt.Fprintln(w, n)

}
