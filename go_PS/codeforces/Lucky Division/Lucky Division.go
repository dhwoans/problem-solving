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

	var n int
	fmt.Fscan(reader, &n)

	if n%4 == 0 || n%7 == 0 || n%44 == 0 || n%47 == 0 || n%74 == 0 || n%77 == 0 || n%444 == 0 || n%447 == 0 || n%474 == 0 || n%744 == 0 || n%477 == 0 || n%747 == 0 || n%774 == 0 || n%777 == 0 {
		fmt.Fprint(writer, "YES")
	} else {
		fmt.Fprint(writer, "NO")

	}

}
