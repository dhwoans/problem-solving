package main

import (
	"bufio"
	"fmt"
	"math"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var n, m, k int
	fmt.Fscan(reader, &n)
	fmt.Fscan(reader, &m)
	fmt.Fscan(reader, &k)
	// n*m*k  n
	sum1 := int(math.Max(float64(n+m+k), float64((n+m)*k)))
	sum2 := int(math.Max(float64(n+m*k), float64(n*(m+k))))
	sum3 := int(math.Max(float64(n*m+k), float64(n*m*k)))
	answer := int(math.Max(float64(sum1), float64(sum2)))
	answer = int(math.Max(float64(answer), float64(sum3)))

	fmt.Fprint(writer, answer)
}
