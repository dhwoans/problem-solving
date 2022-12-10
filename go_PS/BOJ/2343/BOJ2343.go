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
	max := 0
	min := 0
	fmt.Fscanln(r, &n, &m)
	arr := make([]int, n)
	for i := 0; i < n; i++ {
		fmt.Fscan(r, &arr[i])
		max += arr[i]
		min = Max(min, arr[i])
	}
	//파라메트릭 서치
	for min+1 < max {
		mid := (min + max) / 2
		if check(arr, mid, m) {
			max = mid
		} else {
			min = mid

		}
	}
	fmt.Fprintln(w, max)
}
func check(arr []int, mid, m int) bool {
	size := 1
	sum := 0

	for i := 0; i < len(arr); i++ {
		if sum+arr[i] > mid {
			size++
			sum = 0
			if size > m {
				return false
			}
		}
		sum += arr[i]
	}
	return size <= m
}
func Max(a, b int) int {
	if a > b {
		return a
	}
	return b
}
