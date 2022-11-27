package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	var reader = bufio.NewReader(os.Stdin)
	var writer = bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n, m int64
	fmt.Fscan(reader, &n)
	fmt.Fscan(reader, &m)

	var ans int64
	if n < m {
		ans = gcd(m, n)
	} else {
		ans = gcd(n, m)
	}

	for ans > 0 {
		fmt.Fprint(writer, 1)
		ans--
	}
}

func gcd(n int64, m int64) int64 {
	if m == 0 {
		return n
	} else {
		return gcd(m, n%m)
	}
}
