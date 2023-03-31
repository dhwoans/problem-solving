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
	var n, k int
	ans := 0.0
	fmt.Fscanln(r, &n, &k)
	for i := 1; i <= n; i++ {
		var temp float64
		temp = 1.0 / float64(n)
		num := i
		for num < k {
			num *= 2
			temp /= 2
		}
		ans += temp
	}
	fmt.Fprintln(w, ans)
}
