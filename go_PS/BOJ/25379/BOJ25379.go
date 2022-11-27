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
	var n int
	fmt.Fscanln(reader, &n)

	odd := 0
	even := 0
	oddCnt := 0
	evenCnt := 0
	for i := 0; i < n; i++ {
		var num int
		fmt.Fscan(reader, &num)
		if num%2 == 0 {
			even += i - evenCnt
			evenCnt++
		} else {
			odd += i - oddCnt
			oddCnt++
		}
	}
	fmt.Fprintln(writer, int(math.Min(float64(odd), float64(even))))
}
