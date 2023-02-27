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
	var arr [100001]int
	for i := 0; i < n; i++ {
		var temp int
		fmt.Fscan(r, &temp)
		arr[temp]++
		arr[temp+1]++
		if temp != 0 {
			arr[temp-1]++
		}

	}
	ans := 0
	for i := 0; i < len(arr); i++ {
		ans = max(ans, arr[i])
	}
	fmt.Fprintln(w, ans)
}
func max(a, b int) int {
	if a >= b {
		return a
	} else {
		return b
	}
}
