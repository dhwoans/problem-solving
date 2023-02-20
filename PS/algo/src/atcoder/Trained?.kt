package atcoder

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val arr =IntArray(n+1)
    repeat(n){
        arr[it+1]=readLine()!!.toInt()
    }
    val visited = BooleanArray(n+1)
    val que = LinkedList<Pair<Int,Int>>()
    visited[1]=true
    que.add(Pair(1,0))
    while(que.isNotEmpty()){
        val temp = que.poll()
        if(temp.first==2){
            println(temp.second)
            return
        }
        if(visited[arr[temp.first]])continue
        visited[arr[temp.first]]=true
        que.add(Pair(arr[temp.first],temp.second+1))
    }
    println(-1)
}