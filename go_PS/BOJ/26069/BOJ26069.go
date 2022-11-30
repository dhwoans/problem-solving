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
	m := make(map[string]int)
	m["ChongChong"] = 1
	fmt.Fscanln(r, &n)
	for i := 0; i < n; i++ {
		var f, t string
		fmt.Fscanln(r, &f, &t)
		if val, ok := m[f]; ok {
			if val == 1 {
				m[t] = val
			}
		} else {
			m[f] = 0
		}
		if val, ok := m[t]; ok {
			if val == 1 {
				m[f] = val
			}
		} else {
			m[t] = 0
		}
	}
	count := 0
	for k := range m {
		if m[k] == 1 {
			count++
		}
	}
	fmt.Fprintln(w, count)
}
