package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()
	var n, m int
	fmt.Fscanln(reader, &n, &m)
	var target = make([]int, m)
	//정보 입력
	for i := 0; i < m; i++ {
		fmt.Fscan(reader, &target[i])
	}
	//계산
	sum := 0
	cnt := 1
	for i := 0; i < m; i++ {
		if cnt <= target[i] {
			sum += target[i] - cnt
		} else {
			sum += n - cnt + 1
			sum += target[i] - 1
		}
		cnt = target[i]
	}
	fmt.Fprintln(writer, sum)
}
