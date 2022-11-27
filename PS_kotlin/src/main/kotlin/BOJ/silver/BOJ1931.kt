package BOJ.silver

import java.util.PriorityQueue

fun main() {
    val br = System.`in`.bufferedReader()
    val que = PriorityQueue<meeting>()
    val n = br.readLine().toInt()

    //데이터 넣기
    repeat(n){
        val(start,end)= br.readLine().split(" ").map { it.toInt() }
        que.add(meeting(start,end))
    }
    //꺼내기
    var answer =0
    var end =0
    while(que.size>0){
        var time = que.peek()
        if(end<=time.start){
            answer++
            end = time.end
        }
        que.poll()
    }
    println(answer)
}

data class meeting(val start:Int,val end:Int):Comparable<meeting>{
    override fun compareTo(other: meeting): Int = if(end==other.end) start - other.start else end - other.end

}