package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val que = readln().split(" ").map { it.toInt() }.toCollection(LinkedList<Int>())
    val stack = Stack<Int>()
    var num = 1
    while (true) {
        //탈출조건
        if (num == n) {
            break;
        }
        //큐확인
        if (que.isNotEmpty() && que.peek() == num) {
            que.poll()
            num++

        }
        //스택확인
        else if (stack.isNotEmpty() && stack.peek() == num) {
            stack.pop()
            num++

        }

        else if (que.isEmpty() && stack.peek() != num) {
            println("Sad")
            return
        } else {
            stack.add(que.poll())
        }
    }
    println("Nice")
}