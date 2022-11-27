package main

import (
	"bufio"
	"fmt"
	"math"
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
	n, k, sum, max := 0, 0, 0, math.MinInt
	fmt.Fscan(r, &n, &k)
	var arr = make([]int, n)

	for i := 0; i < len(arr); i++ {
		var num int
		fmt.Fscan(r, &num)
		sum += num
		arr[i] = sum
	}

	for i := 0; i < len(arr)-k+1; i++ {
		num := 0
		if i == 0 {
			num = arr[k-1]
		} else {
			num = arr[i+k-1] - arr[i-1]
		}
		if max < num {
			max = num
		}
	}
	fmt.Fprintln(w, max)
}
