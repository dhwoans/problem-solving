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
	var temp string
	fmt.Fscanln(r, &temp)
	str := []rune(temp)
	//사전순
	//홀수 2개면 터짐
	alpha := [27]int{0}
	for i := 0; i < len(str); i++ {
		alpha[str[i]-'A']++
	}
	var ans []rune
	count := 0
	ans = make([]rune, len(str))
	for i := 0; i < len(alpha); i++ {
		if alpha[i] > 0 {
			for true {
				if alpha[i] == 0 {
					break
				} else if alpha[i] == 1 {
					ans[len(ans)/2] = rune(i + 'A')
					alpha[i]--
				} else {
					alpha[i] -= 2
					ans[count] = rune(i + 'A')
					ans[len(str)-1-count] = rune(i + 'A')
					count++
				}
			}
		}
	}
	for i := 0; i < len(ans); i++ {
		if ans[i] == 0 {
			fmt.Println("I'm Sorry Hansoo")
			return
		}
	}
	for i := 0; i < len(ans); i++ {

		fmt.Fprintf(w, "%c", ans[i])
	}
}
