package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r     = bufio.NewReader(os.Stdin)
	w     = bufio.NewWriter(os.Stdout)
	prime = make([]bool, 100_001)
	ans   = make([]bool, 500_001)
)

func main() {
	defer w.Flush()
	var number []int
	//소수체
	for i := 2; i < len(prime); i++ {
		if prime[i] {
			continue
		}
		number = append(number, i)
		j := 2
		for i*j < len(prime) {
			prime[i*j] = true
			j++
		}
	}
	for i := 0; i < len(number); i++ {
		for j := 0; j < len(number); j++ {
			if i == j {
				continue
			}
			if number[i]*number[j] > len(ans) {
				continue
			}
			ans[number[i]*number[j]] = true
		}

	}
	var n int
	fmt.Fscanln(r, &n)
	for i := 0; i < n; i++ {
		var num int
		fmt.Fscanln(r, &num)
		for j := num; j < len(ans); j++ {
			if ans[j] {
				fmt.Fprintln(w, j)
				break
			}
		}
	}
}
