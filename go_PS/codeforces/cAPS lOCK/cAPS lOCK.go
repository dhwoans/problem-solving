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
	var str string
	fmt.Fscanln(reader, &str)
	arr := []rune(str)
	//대문자만 포함하거나
	arr0Isupper := false
	if arr[0] >= 'A' && arr[0] <= 'Z' {
		arr0Isupper = true
	}
	//첫 번째 문자를 제외한 모든 문자가 대문자
	modify := true
	for i := 1; i < len(arr); i++ {
		if arr[i] >= 'A' && arr[i] <= 'Z' {
			modify = true
		} else {
			modify = false
			break
		}
	}
	//변경
	if modify {
		for i := 0; i < len(arr); i++ {
			if i == 0 {
				if arr0Isupper {
					arr[i] += 32
				} else {
					arr[i] -= 32
				}
			} else {
				if arr[i] >= 'A' && arr[i] <= 'Z' {
					arr[i] += 32
				}
			}
		}
	}
	//출력
	for _, v := range arr {
		fmt.Printf("%c", v)
	}
}
