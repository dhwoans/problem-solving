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
	num := make([]int, 9)
	for i := 0; i < 9; i++ {
		fmt.Fscan(r, &num[i])
	}

	if (num[0]+num[4]+num[8] == num[1]+num[5]+num[6]) && (num[1]+num[5]+num[6] == num[2]+num[3]+num[7]) {
		fmt.Fprintln(w, "Yes")
	} else {
		fmt.Fprintln(w, "No")
	}

}
