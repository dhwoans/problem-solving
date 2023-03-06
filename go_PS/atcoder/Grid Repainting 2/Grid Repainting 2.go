package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	r       = bufio.NewReader(os.Stdin)
	w       = bufio.NewWriter(os.Stdout)
	arr     [][]rune
	visited [][]bool
)

func main() {
	defer w.Flush()
	var x, y int
	fmt.Fscanln(r, &x, &y)
	arr = make([][]rune, x)
	for i := 0; i < x; i++ {
		var temp string
		fmt.Fscanln(r, &temp)
		arr[i] = []rune(temp)
	}
	visited = make([][]bool, x)
	for i := 0; i < x; i++ {
		visited[i] = make([]bool, y)
	}
	//bfs
	for i := 0; i < x; i++ {
		for j := 0; j < y; j++ {
			if arr[i][j] == '#' && !visited[i][j] {
				val := bfs(i, j)
				if val == 0 {
					fmt.Fprintln(w, "No")
					return
				}
			}
		}
	}
	fmt.Fprintln(w, "Yes")
}
func bfs(r, c int) int {
	var dir = [4][2]int{
		{-1, 0},
		{1, 0},
		{0, -1},
		{0, 1},
	}
	count := 0
	var que [][2]int
	visited[r][c] = true
	que = append(que, [2]int{r, c})

	for len(que) != 0 {
		x := que[0][0]
		y := que[0][1]
		que = que[1:]
		for i := 0; i < 4; i++ {
			nx := x + dir[i][0]
			ny := y + dir[i][1]

			if nx < 0 || ny < 0 || nx >= len(arr) || ny >= len(arr[0]) {
				continue
			}
			if visited[nx][ny] {
				continue
			}
			if arr[nx][ny] == '.' {
				continue
			}
			que = append(que, [2]int{nx, ny})
			visited[nx][ny] = true
			count++
		}
	}
	return count
}
