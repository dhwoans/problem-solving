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
	//nH(m-n)
	m -= n
	//n+m-1Cm
	n += m - 1
	sum := 1
	for i := n; i > m; i-- {
		sum *= i
	}
	for i := 1; i <= n-m; i++ {
		sum /= i
	}
	fmt.Fprintln(w, sum)
}
