package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	r = bufio.NewReader(os.Stdin)
	w = bufio.NewWriter(os.Stdout)
)

func main() {
	defer w.Flush()
	var n int
	fmt.Fscanln(r, &n)
	count := 0
	for i := 0; i < n; i++ {
		var str string
		fmt.Fscanln(r, &str)
		str = strings.Replace(str, "D-", "", -1)
		num, _ := strconv.Atoi(str)
		if num <= 90 {
			count++
		}
	}
	fmt.Fprintln(w, count)
}
