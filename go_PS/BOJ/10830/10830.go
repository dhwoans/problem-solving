package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r   = bufio.NewReader(os.Stdin)
	w   = bufio.NewWriter(os.Stdout)
	MOD = 1_000
	arr [][]int
)

func main() {
	defer w.Flush()
	var n, b int
	fmt.Fscanln(r, &n, &b)
	arr = make([][]int, n)

	// 배열 입력
	for i := 0; i < n; i++ {
		arr[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Fscan(r, &arr[i][j])
			arr[i][j] %= MOD
		}
	}
	//분할 정복
	ans := pow(arr, b)

	//출력
	for i := 0; i < len(ans); i++ {
		for j := 0; j < len(ans); j++ {
			fmt.Fprintf(w, "%d ", ans[i][j])
		}
		fmt.Fprintln(w)
	}

}
func pow(a [][]int, exponant int) [][]int {
	if exponant == 1 {
		return a
	}
	ans := pow(a, exponant/2)
	ans = mul(ans, ans)
	if exponant%2 == 1 {
		ans = mul(ans, arr)
	}
	return ans
}
func mul(a, b [][]int) [][]int {

	var result [][]int
	result = make([][]int, len(arr))

	for i := 0; i < len(arr); i++ {
		result[i] = make([]int, len(arr))
		for j := 0; j < len(arr); j++ {
			for k := 0; k < len(arr); k++ {

				result[i][j] += a[i][k] * b[k][j]
				result[i][j] %= MOD
			}
		}
	}
	return result
}
