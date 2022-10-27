package BOJ.gold

import java.util.*

fun main() {
    val(t,n) = readLine()!!.split(" ").map(String::toInt)
    val que = PriorityQueue<Triple<Int,Int,Int>>(compareBy({-it.third},{it.first}))
    val sb = StringBuilder()
    repeat(n){
        val (a,b,c ) = readLine()!!.split(" ").map(String::toInt)
        que.add(Triple(a,b,c))
    }
    repeat(t){
        val temp = que.poll()
        val process = Triple<Int,Int,Int>(temp.first,temp.second-1,temp.third-1)
        sb.appendLine(process.first)
        if(process.second!=0) que.add(process)
    }
    println(sb)
}