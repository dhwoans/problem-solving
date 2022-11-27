package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r   *bufio.Reader
	w   *bufio.Writer
	arr [][]int
)

func init() {
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
}

func main() {
	defer w.Flush()
	var n int
	fmt.Fscanln(r, &n)
	arr = make([][]int, n)
	for i := 0; i < n; i++ {
		arr[i] = make([]int, n)
	}
	recusion(0, 0, n)

	for i := 0; i < n; i++ {
		for j := 0; j < n; j++ {
			if arr[i][j] == 0 {
				fmt.Fprint(w, "*")
			} else {
				fmt.Fprint(w, " ")
			}
		}
		fmt.Fprintln(w)
	}

}
func recusion(s, e, n int) {
	if n == 1 {
		return
	} else {
		m := n / 3
		for i := s; i < s+n; i++ {
			for j := e; j < e+n; j++ {
				if (i-s)/m == 1 && (j-e)/m == 1 {
					arr[i][j] = 1
				}
			}
		}
		recusion(s+0*m, e+0*m, m)
		recusion(s+0*m, e+1*m, m)
		recusion(s+0*m, e+2*m, m)
		recusion(s+1*m, e+0*m, m)
		recusion(s+1*m, e+2*m, m)
		recusion(s+2*m, e+0*m, m)
		recusion(s+2*m, e+1*m, m)
		recusion(s+2*m, e+2*m, m)
	}
}
