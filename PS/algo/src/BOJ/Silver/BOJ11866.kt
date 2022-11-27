package BOJ.silver

import java.io.BufferedReader
import java.util.LinkedList
import java.util.Queue

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val que:Queue<Int> = LinkedList<Int>()
    val sb = StringBuilder()
    var count = 1
    sb.append("<")
    (1..n).forEach { que.add(it.toInt()) }
    while (que.size != 1) {
        if (count == m) {
            sb.append(que.poll()).append(",").append(" ")
            count=1
        } else {
            que.add(que.poll())
            count++
        }

    }
    sb.append(que.poll()).append(">")
    println(sb)
}
