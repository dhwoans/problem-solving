package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val que = PriorityQueue<Int>(Comparator.reverseOrder())
    var ans =0
    repeat(n){
        readln().split(" ").map{it.toInt()}.forEach{
            que.add(it)
        }
    }
    repeat(n){
        ans = que.poll()
    }
    println(ans)
}
