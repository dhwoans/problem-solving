package BOJ.Gold

private lateinit var visited: Array<BooleanArray>
private lateinit var arr: Array<CharArray>
val dir = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, 1)
    this[3] = intArrayOf(0, -1)
}
private var flag = false

fun main() {
    val (n, m) = readln().split(" ").map { it.toInt() }
    arr = Array(n) { CharArray(m) }.apply{
        repeat(n) {
            this[it] = readln().toCharArray()
        }
    }

    visited = Array(n) { BooleanArray(m) }
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j]) continue
            dfs(i, j, -1, -1)
            if (flag) {
                println("Yes")
                return
            }
        }
    }
    println("No")
}

private fun dfs(x: Int, y: Int, prex: Int, prey: Int) {
    for (i in dir) {
        val nx = x + i[0]
        val ny = y + i[1]

        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
        if (arr[x][y] != arr[nx][ny]) continue
        if (nx == prex && ny == prey) continue
        if (visited[nx][ny]) {
            flag = true
            return
        }

        visited[nx][ny] = true
        dfs(nx, ny, x, y)
    }
}

