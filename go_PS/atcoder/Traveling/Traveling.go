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
	x := 0
	y := 0
	time := 0
	for i := 0; i < n; i++ {
		var s, a, b int
		fmt.Fscanln(r, &s, &a, &b)
		v := abs(x-a) + abs(y-b)
		time = abs(time - s)
		if v > time {
			fmt.Fprintln(w, "No")
			return
		} else if (time-v)%2 != 0 {
			fmt.Fprintln(w, "No")
			return

		}
		x = a
		y = b
		time = s
	}
	fmt.Fprintln(w, "Yes")
}
func abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
