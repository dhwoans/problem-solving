package BOJ.gold


val dir = Array(3) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 1)
    this[1] = intArrayOf(0, 1)
    this[2] = intArrayOf(1, 1)
}
lateinit var map: Array<CharArray>
lateinit var visited: Array<BooleanArray>
var count = 0
var flag = false

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c) = br.readLine().split(" ").map { it.toInt() }
    map = Array(r) { CharArray(c) }
    visited = Array(r) { BooleanArray(c) }

    repeat(r) { map[it] = br.readLine().toCharArray() }

    for (i in 0 until r) {
        flag = false
        dfs(i, 0)

    }
    println(count)
}

fun dfs(r: Int, c: Int) {
    visited[r][c] = true

    if (c == map[0].size - 1) {
        count++
        flag = true
        return
    } else {
        for (i in 0..2) {
            val nr = r + dir[i][0]
            val nc = c + dir[i][1]
            if (nr < 0 || nr >= map.size || nc >= map[0].size) continue
            if (visited[nr][nc] || map[nr][nc] == 'x') continue
            dfs(nr, nc)
            if (flag) return

        }

    }
}