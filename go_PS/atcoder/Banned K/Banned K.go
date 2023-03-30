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
	arr := make([]int, n)
	m := make(map[int]int)
	for i := 0; i < n; i++ {
		var temp int
		fmt.Fscan(r, &temp)
		arr[i] = temp
		m[temp] = m[temp] + 1
	}
	ans := make([][2]int, 200001)
	sum := 0
	for k, v := range m {
		a1 := v * (v - 1) / 2
		a2 := 0
		if v-1 >= 2 {
			a2 = (v - 2) * (v - 1) / 2
		}
		ans[k] = [2]int{a1, a2}
		sum += a1
	}
	for i := 0; i < len(arr); i++ {
		answer := sum
		answer += ans[arr[i]][1] - ans[arr[i]][0]
		fmt.Fprintln(w, answer)
	}
}
