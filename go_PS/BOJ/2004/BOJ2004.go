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
	var n, m int64
	fmt.Fscanln(r, &n, &m)

	twon := checkT(n)
	fiven := checkF(n)
	twonm := checkT(n - m)
	fivenm := checkF(n - m)
	twom := checkT(m)
	fivem := checkF(m)

	two := twon - (twonm + twom)
	five := fiven - (fivenm + fivem)
	if two > five {
		fmt.Fprintln(w, five)
	} else {
		fmt.Fprintln(w, two)
	}
}

func checkT(num int64) int64 {
	var count int64 = 0
	for num > 0 {
		num /= 2
		count += num
	}
	return count
}

func checkF(num int64) int64 {
	var count int64 = 0
	for num > 0 {
		num /= 5
		count += num
	}
	return count
}
