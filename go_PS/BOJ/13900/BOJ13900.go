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
	var arr = make([]int64, n)
	var sum int64 = 0
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
		sum += arr[i]
	}

	var ans int64 = 0
	for i := 0; i < len(arr)-1; i++ {
		sum -= arr[i]
		ans += arr[i] * sum
	}
	fmt.Fprintln(w, ans)
}
