package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r   = bufio.NewReader(os.Stdin)
	w   = bufio.NewWriter(os.Stdout)
	arr [][]rune
)

func main() {
	defer w.Flush()
	var n int
	fmt.Fscanln(r, &n)

	arr = make([][]rune, n)
	for i := 0; i < len(arr); i++ {
		arr[i] = make([]rune, n)
		var str string
		fmt.Fscanln(r, &str)
		arr[i] = []rune(str)
	}
	for i := 0; i < len(arr); i++ {
		for j := 0; j < len(arr[i]); j++ {
			if arr[i][j] != '.' {
				if row(i, j) {
					fmt.Fprintf(w, "%c\n", arr[i][j])
					return
				}
				if col(i, j) {
					fmt.Fprintf(w, "%c\n", arr[i][j])
					return
				}
				if diagonal(i, j) {
					fmt.Fprintf(w, "%c\n", arr[i][j])
					return
				}
			}
		}

	}

	fmt.Fprintln(w, "ongoing")
}

func diagonal(i int, j int) bool {
	count := 1
	for k := 1; k <= 2; k++ {
		if i+k < len(arr) && j+k < len(arr) && arr[i+k][j+k] == arr[i][j] {
			count++
		} else {
			break
		}
	}
	if count >= 3 {
		return true

	}
	count = 1
	for k := 1; k <= 2; k++ {
		if i+k < len(arr) && j-k >= 0 && arr[i+k][j-k] == arr[i][j] {
			count++
		} else {
			return false
		}
	}
	if count >= 3 {
		return true
	}
	return false
}

func col(i, j int) bool {
	count := 1
	for k := 1; k <= 2; k++ {
		if i+k < len(arr) && arr[i][j] == arr[i+k][j] {
			count++
		} else {
			return false
		}
	}
	return count >= 3
}

func row(i, j int) bool {
	count := 1
	for k := 1; k <= 2; k++ {
		if j+k < len(arr) && arr[i][j] == arr[i][j+k] {
			count++
		} else {
			return false
		}
	}
	return count >= 3
}
