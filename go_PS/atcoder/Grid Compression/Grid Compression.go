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
	var x, y int
	fmt.Fscanln(r, &x, &y)
	arr := make([][]rune, x)
	row := make([]bool, x)
	col := make([]bool, y)
	//맵 정보
	for i := 0; i < x; i++ {
		arr[i] = make([]rune, y)
		var temp string
		fmt.Fscanln(r, &temp)
		arr[i] = []rune(temp)
	}
	//가로 체크
	for i := 0; i < x; i++ {
		flag := true
		for j := 0; j < y; j++ {
			if arr[i][j] == '#' {
				flag = false
				break
			}
		}
		row[i] = flag
	}
	//세로 체크
	for i := 0; i < y; i++ {
		flag := true
		for j := 0; j < x; j++ {
			if arr[j][i] == '#' {
				flag = false
				break
			}
		}
		col[i] = flag
	}

	for i := 0; i < x; i++ {
		temp := true
		for j := 0; j < y; j++ {
			if row[i] {
				temp = false
				break
			} else if col[j] {
				continue
			}
			fmt.Fprintf(w, "%c", arr[i][j])
		}
		if temp {
			fmt.Fprintln(w)
		}
	}
}
