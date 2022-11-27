package main

import (
	"bufio"
	"fmt"
	"math"
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
	n, m, k := 0, 0, 0
	fmt.Fscan(r, &n, &m, &k)

	var check1 = make([][]int, n)
	var check2 = make([][]int, n)
	var ch = 'B'
	for i := 0; i < n; i++ {
		check1[i] = make([]int, m)
		check2[i] = make([]int, m)
		var str string
		fmt.Fscan(r, &str)
		char := []rune(str)
		if i%2 == 0 {
			ch = 'B'
		} else {
			ch = 'W'
		}
		for j := 0; j < m; j++ {
			if char[j] == ch {
				check1[i][j] = 1
			} else {
				check2[i][j] = 1
			}
			if ch == 'W' {
				ch = 'B'
			} else {
				ch = 'W'
			}
		}
	}
	//행누적
	for i := 0; i < n; i++ {
		for j := 1; j < m; j++ {
			check1[i][j] += check1[i][j-1]
			check2[i][j] += check2[i][j-1]
		}
	}
	//열누적
	for i := 0; i < m; i++ {
		for j := 1; j < n; j++ {
			check1[j][i] += check1[j-1][i]
			check2[j][i] += check2[j-1][i]
		}
	}
	//최소값 구하기
	//(x1, y1, x2, y2) = (x2, y2) - (x1, y2) - (x2, y1) + (x1, y1)
	min1, min2 := math.MaxInt, math.MaxInt
	for i := 0; i < n-k+1; i++ {
		for j := 0; j < m-k+1; j++ {
			num1, num2 := 0, 0
			if i == 0 && j == 0 {
				num1 = check1[k-1][k-1]
				num2 = check2[k-1][k-1]
			} else if i == 0 && j != 0 {

				num1 = check1[i+k-1][j+k-1] - check1[i+k-1][j-1]
				num2 = check2[i+k-1][j+k-1] - check2[i+k-1][j-1]
			} else if i != 0 && j == 0 {
				num1 = check1[i+k-1][k-1] - check1[i-1][j+k-1]
				num2 = check2[i+k-1][k-1] - check2[i-1][j+k-1]

			} else {
				num1 = check1[i+k-1][j+k-1] - check1[i-1][j+k-1] - check1[i+k-1][j-1] + check1[i-1][j-1]
				num2 = check2[i+k-1][j+k-1] - check2[i-1][j+k-1] - check2[i+k-1][j-1] + check2[i-1][j-1]
			}
			if min1 > num1 {
				min1 = num1
			}
			if min2 > num2 {
				min2 = num2
			}
		}
	}

	if min1 > min2 {
		fmt.Fprintln(w, min2)
	} else {
		fmt.Fprintln(w, min1)
	}
}
