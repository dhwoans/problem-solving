package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	r := bufio.NewReader(os.Stdin)
	w := bufio.NewWriter(os.Stdout)
	defer w.Flush()

	var t int
	fmt.Fscan(r, &t)
	for i := 0; i < t; i++ {
		var n int
		fmt.Fscan(r, &n)
		var stack []rune
		var ch string
		fmt.Fscan(r, &ch)
		for m := 0; m < len(ch); m++ {
			if len(stack) == 0 {
				stack = append(stack, rune(ch[m]))
			} else if stack[len(stack)-1] == '(' && ch[m] == ')' {
				stack = stack[:len(stack)-1]
			} else {
				stack = append(stack, rune(ch[m]))
			}
		}

		fmt.Fscanln(r)
		fmt.Fprintln(w, len(stack)/2)
	}
}
