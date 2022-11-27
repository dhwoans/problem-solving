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
	for i := 0; i < n; i++ {
		var num int
		fmt.Fscanln(r, &num)
		if num%2 == 0 {
			fmt.Fprint(w, "1 3 ")
			for j := 0; j < num-2; j++ {
				fmt.Fprint(w, "2 ")
			}
			fmt.Fprintln(w)
		} else {
			for j := 0; j < num; j++ {
				fmt.Fprint(w, "1 ")
			}
			fmt.Fprintln(w)
		}
	}
}
