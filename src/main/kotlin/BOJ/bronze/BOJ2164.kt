package BOJ

import java.util.*

fun main() = with(System.`in`.bufferedReader()){
    val n = readLine()!!.toInt()
    val que:Queue<Int> = LinkedList()

    for (i in 1 .. n) {
        que.add(i)
    }
    while(que.size!=1){
        que.poll()
        que.add(que.poll())
    }
    println(que.poll());
}