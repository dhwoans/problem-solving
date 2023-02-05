package BOJ.Gold

import java.util.*

fun main() {
    val arr = ArrayList<Pair<Int,Int>>()
    repeat(readln().toInt()){
        val (f,t) = readln().split(" ").map{it.toInt()}
        arr.add(Pair(f,t))
    }
    //시작 시간 정렬
    arr.sortWith(compareBy { it.first })
    val que = PriorityQueue<Int>()
    for(i in 0 until arr.size){
        val temp = arr[i]
        que.add(temp.second)
        if (que.isNotEmpty() && que.peek() <= temp.first) que.poll()
    }
    println(que.size)
}