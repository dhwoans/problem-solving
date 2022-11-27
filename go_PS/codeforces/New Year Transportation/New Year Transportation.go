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

	n, t := 0, 0
	fmt.Fscan(r, &n, &t)
	var arr = make([]int, n)
	for i := 0; i < n-1; i++ {
		fmt.Fscan(r, &arr[i])
	}
	cnt := 0
	for cnt < t-1 {
		cnt += arr[cnt]
	}
	if cnt == t-1 {
		fmt.Fprintln(w, "YES")
	} else {
		fmt.Fprintln(w, "NO")
	}
}
