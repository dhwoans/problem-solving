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
	var n, t int
	fmt.Fscanln(r, &n, &t)
	people := make([]int, n)
	ans := t
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &people[i])
	}

	for i := 1; i < n; i++ {
		val := people[i] - people[i-1]
		ans += min(val, t)
	}
	fmt.Fprintln(w, ans)
}
func min(x, y int) int {
	if x > y {
		return y
	} else {
		return x
	}
}
