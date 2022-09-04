package BOJ.gold

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val que = PriorityQueue<Long>()
    repeat(n){
        que.add(br.readLine().toLong())
    }
    var sum =0L
    while (que.size!=1){
        var num = que.poll()+que.poll()
        sum+=num
        que.add(num)
    }
    println(sum)
}