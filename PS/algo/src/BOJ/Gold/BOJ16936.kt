package BOJ.Gold


private val ans = ArrayList<Long>()
fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toLong() }.toLongArray()
    val visited = BooleanArray(arr.size)
    for (i in visited.indices) {
        if (visited[i]) continue
        dfs(i, arr, visited)
    }
    ans.reverse()
    ans.forEach {
        print("${it} ")
    }
}

private fun dfs(next: Int, arr: LongArray, visited: BooleanArray) {
    visited[next] = true
    if (arr.contains(arr[next] * 2)) {
        val temp = arr.indexOf(arr[next] * 2)
        if (!visited[temp]) {

            dfs(temp, arr, visited)
        }
    } else if (arr[next] % 3 == 0L && arr.contains(arr[next] / 3)) {
        val temp = arr.indexOf(arr[next] / 3)
        if (!visited[temp]) {

            dfs(temp, arr, visited)
        }
    }
    ans.add(arr[next])
}