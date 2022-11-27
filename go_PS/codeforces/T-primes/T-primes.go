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
	//소수 체만들기
	prime := [1000001]bool{}
	prime[0] = true
	prime[1] = true
	for i := 2; i < len(prime); i++ {
		if prime[i] {
			continue
		}
		for j := 2; j < len(prime); j++ {
			if i*j < len(prime) {
				prime[i*j] = true
			} else {
				break
			}
		}
	}
	var n int
	fmt.Fscanln(reader, &n)
	for i := 0; i < n; i++ {
		var num int64
		fmt.Fscan(reader, &num)
		a := int(math.Sqrt(float64(num)))
		if !prime[a] && int64(a*a) == num {
			fmt.Fprintln(writer, "YES")
		} else {
			fmt.Fprintln(writer, "NO")
		}

	}
}
