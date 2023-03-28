package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

var (
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
)

func main() {
	defer w.Flush()
	var red, g, b, n int
	fmt.Fscanln(r, &red, &g, &b, &n)
	var arr = make([]int, 3001)
	ball := []int{red, g, b}
	sort.Ints(ball)
	for i := 0; i < len(ball); i++ {
		arr[ball[i]]++
		for j := ball[i] + 1; j < len(arr); j++ {
			arr[j] += arr[j-ball[i]]
		}
	}
	fmt.Fprintln(w, arr[n])
}
