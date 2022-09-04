package BOJ.silver

import java.io.BufferedReader
import java.util.Deque
import java.util.LinkedList

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val que: Deque<Int> = LinkedList<Int>()
    val (n, m) = readLine().split(" ").map { it.toInt() }
    val findNum = readLine().split(" ").map { it.toInt() }.toIntArray()
    var count = 0
    (1..n).forEach { que.add(it) }
    for (i in findNum) {
        val findNum = que.indexOf(i)
        if (findNum < que.size - findNum) {
            while (que.peek() != i) {
                que.addLast(que.pollFirst())
                count++
            }
        } else {
            while (que.peek() != i) {
                que.addFirst(que.pollLast())
                count++
            }
        }
        que.poll()
    }
    println(count)


}