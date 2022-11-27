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
	max := 0
	fmt.Fscanln(r, &n)
	var arr = make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
	}
	var m = make(map[int]int)
	for i := 0; i < len(arr); i++ {
		_, exists := m[arr[i]-1]
		if !exists {
			m[arr[i]] = 1
		} else {
			m[arr[i]] = m[arr[i]-1] + 1
		}
		if m[arr[i]] > max {
			max = m[arr[i]]
		}
	}
	fmt.Fprintln(w, max)
}
