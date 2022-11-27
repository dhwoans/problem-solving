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

	var n int
	fmt.Fscanln(r, &n)
	arr := make([]int, 100_001)
	for i := 0; i < n; i++ {
		var num int
		fmt.Fscan(r, &num)
		arr[num]++
	}
	dp := make([]int, 100_001)
	dp[1] = 1 * arr[1]
	if 2*arr[2] < dp[1] {
		dp[2] = dp[1]
	} else {
		dp[2] = 2 * arr[2]
	}
	for i := 3; i < len(dp); i++ {
		if i*arr[i]+dp[i-2] < dp[i-1] {
			dp[i] = dp[i-1]
		} else {
			dp[i] = i*arr[i] + dp[i-2]
		}

	}
	max := math.MinInt
	for i := 1; i < len(dp); i++ {
		if max < dp[i] {
			max = dp[i]
		}
	}
	fmt.Fprintln(w, max)
}
