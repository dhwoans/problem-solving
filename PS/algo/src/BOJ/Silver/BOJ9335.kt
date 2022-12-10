package BOJ.Silver

import java.lang.Integer.min

private lateinit var visited: BooleanArray
private lateinit var arr: ArrayList<ArrayList<Int>>
private var min = Int.MAX_VALUE

fun main() {
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
            for (i in 1 .. temp[0]) {
                arr[it + 1].add(temp[i])
            }
        }
        visited = BooleanArray(n)
        for(i in 1 .. n){
            permutation(0, n,1,i)
        }
        println(min)
    }
}

private fun permutation(cnt: Int, n: Int, count: Int,start:Int) {
    if (cnt == n) {
        min = min(min,count)
        return
    }
    for (i in start..n) {
        if (visited[i - 1]) continue
        visited[i - 1] = true
        add(i)
        if (check()) {
            min = min(min,count)
            visited[i - 1] = false
            clean(i)
            return
        } else {
            permutation(cnt + 1, n, count + 1,1)
        }
        visited[i - 1] = false
        clean(i)
    }
}

private fun clean(i: Int) {
    for (i in arr[i]) {
        visited[i-1] = false
    }
}

private fun add(i: Int) {
    for (i in arr[i]) {
        visited[i-1] = true
    }
}

private fun check(): Boolean {
    return visited.count { !it } == 0
}