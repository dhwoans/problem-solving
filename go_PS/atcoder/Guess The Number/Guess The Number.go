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
	fmt.Fscanln(r, &n, &m)
	arr := make([]int, n)

	for i := 0; i < len(arr); i++ {
		arr[i] = -1
	}

	for i := 0; i < m; i++ {
		var index, val int
		fmt.Fscanln(r, &index, &val)

		if arr[index-1] != -1 && arr[index-1] != val {
			fmt.Fprintln(w, -1)
			return
		} else {
			arr[index-1] = val
		}
	}
	if len(arr) > 1 && arr[0] == 0 {
		fmt.Fprintln(w, -1)
		return
	} else if len(arr) > 1 && arr[0] == -1 {
		arr[0] = 1
	}

	//print
	for i := 0; i < len(arr); i++ {
		if arr[i] == -1 {
			fmt.Fprint(w, 0)
		} else {
			fmt.Fprint(w, arr[i])
		}

	}
}
