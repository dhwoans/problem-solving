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
	set := make(map[int]struct{})
	for i := 0; i < n; i++ {
		var num int
		fmt.Fscanln(r, &num)
		_, ok := set[num]
		if !ok {
			set[num] = struct{}{}
		} else {
			delete(set, num)
		}
	}
	fmt.Fprintln(w, len(set))
}
