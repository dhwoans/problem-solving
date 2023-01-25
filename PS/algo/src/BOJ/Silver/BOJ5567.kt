package BOJ.Silver

import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val n = readln().toInt()
    val arr = ArrayList<ArrayList<Int>>()
    repeat(n+1){
        arr.add(ArrayList<Int>())
    }
    repeat(readln().toInt()){
        val(n1,n2)= readln().split(" ").map{it.toInt()}
        arr[n1].add(n2)
        arr[n2].add(n1)
    }
    val visited = BooleanArray(n+1)
    val que = LinkedList<Int>()
    que.add(1)
    visited[1]=true
    var count =0
    repeat(2){
        if(que.isEmpty())return@repeat
        val round = que.size
        repeat(round){
            val temp = que.poll()
            for(i in arr[temp]){
                if(visited[i])continue
                visited[i]=true
                que.add(i)
                count++
            }
        }
    }
    println(count)
}
