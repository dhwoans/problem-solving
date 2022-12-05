package BOJ.Silver

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    val arr = Array(n) { IntArray(m) }
    val ans = Array(n) { IntArray(m) { -1 } }
    val visited = Array(n) { BooleanArray(m) }
    val dir = Array(4) { IntArray(2) }.apply {
        this[0] = intArrayOf(-1, 0)
        this[1] = intArrayOf(1, 0)
        this[2] = intArrayOf(0, -1)
        this[3] = intArrayOf(0, 1)
    }
    repeat(n) {
        arr[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    //시작지점 찾기
    var x = 0
    var y = 0
    out@ for (i in arr.indices) {
        for (j in arr[i].indices) {
            if (arr[i][j] == 2) {
                x = i
                y = j
            }else if(arr[i][j]==0){
                ans[i][j]=0
            }
        }
    }
    //bfs
    val que = LinkedList<Pair<Int, Int>>()
    visited[x][y] = true
    ans[x][y]=0
    que.add(Pair(x, y))
    var count = 0
    while (que.isNotEmpty()) {
        val turn = que.size
        count++
        repeat(turn) {
            val temp = que.poll()

            for (i in dir) {
                val nx = temp.first + i[0]
                val ny = temp.second + i[1]

                if (nx < 0 || ny < 0 || nx >= n || ny >= m) continue
                if (visited[nx][ny]) continue
                visited[nx][ny] = true
                if (arr[nx][ny] == 0) {
                    ans[nx][ny] = 0
                } else if (arr[nx][ny] == 1) {
                    ans[nx][ny] = count
                    que.add(Pair(nx, ny))
                }
            }
        }
    }
    //출력
    for (i in ans.indices) {
        for (j in ans[i].indices) {
            print("${ans[i][j]} ")
        }
        println()
    }
}
