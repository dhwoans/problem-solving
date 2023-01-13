package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val temp = readln().split(" ").map{it.toInt()}
    val deque:Deque<Int> = LinkedList<Int>()
    var count =1
    for(i in temp.size-1 downTo 0 ){
        when(temp[i]) {
            1 ->{deque.addLast(count++)}
            2 ->{
                val t = deque.pollLast()
                deque.addLast(count++)
                deque.addLast(t)
            }
            3 ->{deque.addFirst(count++)}
        }
    }
    val sb = StringBuilder()
    while(deque.isNotEmpty()){
        sb.append(deque.pollLast()).append(" ")
    }
    println(sb)
}