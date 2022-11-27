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

	var n int
	fmt.Fscanln(reader, &n)

	var arr = make([][]int, 2)
	for i := 0; i < 2; i++ {
		arr[i] = make([]int, n)
		for j := 0; j < n; j++ {
			fmt.Fscan(reader, &arr[i][j])
		}
	}
	count0 := 0
	count1 := 0
	answer := 0
	for i := 0; i < n; i++ {
		result := check(arr, i)
		if result == 2 {
			if count0 != 0 {
				count0 = 0
				count1++
			} else {
				count0++
				count1 = 0
			}
		} else if result == 1 {
			count1++
			count0 = 0
		} else {
			count0++
			count1 = 0
		}
		if answer < count0 {
			answer = count0
		}
		if answer < count1 {
			answer = count1
		}
	}
	fmt.Fprintln(writer, answer)
}

func check(arr [][]int, i int) int {
	if arr[0][i] == arr[1][i] {
		return 2
	} else if arr[0][i] > arr[1][i] {
		if arr[0][i] == 3 && arr[1][i] == 1 {
			return 1
		}
		return 0
	} else {
		if arr[1][i] == 3 && arr[0][i] == 1 {
			return 0
		}
		return 1
	}
}
