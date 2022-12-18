package BOJ.Gold


import kotlin.collections.ArrayList

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var visited: BooleanArray
private lateinit var answer: ArrayList<Int>

fun main() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    visited = BooleanArray(n + 1)
    answer = ArrayList()

    //인접리스트
    arr = ArrayList<ArrayList<Int>>().apply {
        //노드 생성
        repeat(n + 1) { this.add(ArrayList()) }
        //간선 생성
        repeat(m) {
            val (start, end) = readLine()!!.split(" ").map { it.toInt() }
            this[start].add(end)
        }
    }
    //방문하지 않은 노드에 대해 DFS
//    for (i in 1 .. n){   어떤 노드로 시작 해도 상관없다.
    for (i in n downTo 1) {
        if (visited[i]) continue
        dfs(i)
    }
    answer.reversed().forEach { print("$it ") }
}

private fun dfs(num: Int) {
    visited[num] = true
    for (i in arr[num]) {
        if (visited[i]) continue
        dfs(i)
    }
    //더이상 방문할곳이 없다면
    answer.add(num)
}