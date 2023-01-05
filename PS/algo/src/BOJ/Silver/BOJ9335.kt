package BOJ.Silver

import java.lang.Integer.min

private lateinit var visited: BooleanArray
private lateinit var arr: ArrayList<ArrayList<Int>>
private var min = Int.MAX_VALUE

fun main() {
    val sb = StringBuilder()
    repeat(readln().toInt()) {
        min = Int.MAX_VALUE
        val n = readln().toInt()
        arr = ArrayList<ArrayList<Int>>().apply {
            repeat(n + 1) {
                this.add(ArrayList<Int>())
            }
        }
        repeat(n) {
            val temp = readln().split(" ").map(String::toInt).toIntArray()
            for (i in 1..temp[0]) {
                arr[it + 1].add(temp[i])
            }
        }
        for (i in 1..n) {
            visited = BooleanArray(n)
            visited[i-1]=true
            permutation(0, n, 1, i)
        }
        sb.appendLine(min)
    }
    println(sb)
}

private fun permutation(cnt: Int, n: Int, count: Int, start: Int) {
    if (count > min) return
    if (check()) {
        min = min(min, count-1)
        return
    }
    if (cnt == n) {
        min = min(min, count)
        return
    }
    for (i in start+1..n) {
        visited[i - 1] = true
        add(i)
        permutation(cnt + 1, n, count + 1, 1)
        visited[i - 1] = false
        clean(i)
    }
}

private fun clean(i: Int) {
    for (i in arr[i]) {
        visited[i - 1] = false
    }
}

private fun add(i: Int) {
    for (i in arr[i]) {
        visited[i - 1] = true
    }
}

private fun check(): Boolean {
    return visited.count { !it } == 0
}