package BOJ.silver

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val que = PriorityQueue<info>()
    var time =0
    repeat(n){
        val (arrival,time) = br.readLine().split(" ").map{it.toInt()}
        que.add(info(arrival,time))
    }

    while(que.isNotEmpty()){
        val temp  = que.poll()
        if(time<temp.arrival)time = temp.arrival
        time+=temp.time
    }

    println(time)
}

private data class info(val arrival:Int,val time:Int):Comparable<info>{
    override fun compareTo(other: info): Int {
        return arrival - other.arrival
    }

}