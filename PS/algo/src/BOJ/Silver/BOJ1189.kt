package BOJ.silver

private var dir = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, -1)
    this[3] = intArrayOf(0, 1)
}
private lateinit var arr: Array<CharArray>
private lateinit var visited: Array<BooleanArray>
private var answer = 0

fun main() {
    val (r, c, k) = readLine()!!.split(" ").map(String::toInt)
    arr = Array(r) { CharArray(c) }.apply {
        repeat(r) {
            this[it] = readLine()!!.toCharArray()
        }
    }
    visited = Array(r) { BooleanArray(c) }
    visited[r - 1][0] = true
    dfs(r - 1, 0, 1, k)
    println(answer)
}

fun dfs(r: Int, c: Int, count: Int, k: Int) {
    if (r == 0 && c == arr[0].size - 1) {
        if (count == k) {
            answer++
        }
    }
    for (i in 0 until 4) {
        val nx = r + dir[i][0]
        val ny = c + dir[i][1]
        if (nx < 0 || ny < 0 || nx >= arr.size || ny >= arr[0].size) continue
        if (visited[nx][ny]) continue
        if (arr[nx][ny] == 'T') continue
        visited[nx][ny] = true
        dfs(nx, ny, count + 1, k)
        visited[nx][ny] = false
    }
}