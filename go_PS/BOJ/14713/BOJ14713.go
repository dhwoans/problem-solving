package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)
	var arr [][]string
	for i := 0; i < n; i++ {
		var que []string
		str, _, _ := reader.ReadLine()
		slice := strings.Split(string(str), " ")
		for _, val := range slice {
			que = append(que, val)
		}
		arr = append(arr, que)
	}

	receive, _, _ := reader.ReadLine()
	var s []string
	if len(receive) == 1 {
		s[0] = string(receive)
	} else {
		s = strings.Split(string(receive), " ")
	}
	for _, val := range s {
		flag := true
		for j, word := range arr {
			if len(word) != 0 && val == word[0] {
				flag = false
				arr[j] = arr[j][1:]
			}
		}
		if flag {
			fmt.Fprintln(writer, "Impossible")
			return
		}
	}
	for _, i := range arr {
		if len(i) != 0 {
			fmt.Fprintln(writer, "Impossible")
			return
		}
	}
	fmt.Fprintln(writer, "Possible")
}
