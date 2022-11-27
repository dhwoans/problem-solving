package codeforces

import java.util.*

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val visited = BooleanArray(10_001)
    val que = LinkedList<Pair<Int, Int>>()
    que.add(Pair(n, 0))
    visited[n] = true
    while (que.isNotEmpty()) {
        val temp = que.poll()

        if (temp.first == m) {
            println(temp.second)
            return
        }
        if (temp.first * 2 < visited.size && !visited[temp.first * 2]){
            visited[temp.first * 2] = true
            que.add(Pair(temp.first * 2, temp.second + 1))
        }

        if (temp.first - 1 >= 0 && !visited[temp.first - 1]){
            visited[temp.first - 1] = true
            que.add(Pair(temp.first - 1, temp.second + 1))
        }
    }
}