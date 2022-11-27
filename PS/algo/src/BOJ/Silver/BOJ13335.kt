package BOJ.silver

import java.util.LinkedList
import java.util.Queue

val br = System.`in`.bufferedReader()

fun main() {
    val (n, w, l) = br.readLine().split(" ").map { it.toInt() }
    val start: Queue<Int> = LinkedList<Int>()
    val bridge: Queue<Int> = LinkedList<Int>()

    br.readLine().split(" ").forEach { start.add(it.toInt()) }
    repeat(w){bridge.add(0)}

    var answer = 0
    while(bridge.isNotEmpty()){
        answer++
        bridge.poll()
        if(start.isNotEmpty()){
            if(start.peek()+bridge.sum()<=l)bridge.add(start.poll())
            else bridge.add(0)
        }

    }
    println(answer)
}