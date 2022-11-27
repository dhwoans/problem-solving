package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r *bufio.Reader
	w *bufio.Writer
)

func init() {
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
}

func main() {
	defer w.Flush()

	n := 0
	fmt.Fscanln(r, &n)
	var l = make([]int, 6)
	// 방향 길이 정보
	dir, length, max12, max34, indx1, indx2 := 0, 0, 0, 0, 0, 0
	for i := 0; i < 6; i++ {
		fmt.Fscanln(r, &dir, &length)
		l[i] = length
		switch dir {
		case 1, 2:
			if max12 < length {
				max12 = length
				indx1 = i
			}
		case 3, 4:
			if max34 < length {
				max34 = length
				indx2 = i
			}
		}
	}
	// 인접하지 않은 변 구하기
	arr := make([]bool, 6)
	arr[indx1] = true
	arr[(indx1+1)%6] = true
	if indx1-1 < 0 {
		arr[5] = true
	} else {
		arr[indx1-1] = true
	}
	arr[indx2] = true
	arr[(indx2+1)%6] = true
	if indx2-1 < 0 {
		arr[5] = true
	} else {
		arr[indx2-1] = true
	}
	big := max12 * max34
	small := 1
	for i := 0; i < len(arr); i++ {
		if !arr[i] {
			small *= l[i]
		}
	}
	fmt.Fprintln(w, (big-small)*n)

}
