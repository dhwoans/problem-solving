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
	var n, m int
	fmt.Fscanln(r, &n, &m)
	s := make([][]int, n)
	b := make([][]int, m)

	for i := 0; i < n; i++ {
		s[i] = make([]int, 2)
		var x, y int
		fmt.Fscanln(r, &x, &y)
		s[i][0] = x
		s[i][1] = y
	}
	for i := 0; i < m; i++ {
		b[i] = make([]int, 2)
		var x, y int
		fmt.Fscanln(r, &x, &y)
		b[i][0] = x
		b[i][1] = y
	}
	for i := 0; i < n; i++ {
		dis := 300_000_000
		ans := 0
		for j := 0; j < m; j++ {
			cal := abs(b[j][0], s[i][0]) + abs(b[j][1], s[i][1])
			if dis > cal {
				dis = cal
				ans = j + 1
			}
		}
		fmt.Fprintln(w, ans)
	}
}
func abs(a, b int) int {
	if a-b > 0 {
		return a - b
	}
	return -(a - b)
}
func max(a, b int) int {
	if a >= b {
		return a
	}
	return b
}
