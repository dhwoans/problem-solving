package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var indegree:IntArray
private val sb = StringBuilder()

fun main() {
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    indegree = IntArray(n+1)
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n+1){
            this.add(ArrayList())
        }
        repeat(m){
            val (start,end) = readLine()!!.split(" ").map(String::toInt)
            this[start].add(end)
            indegree[end]++
        }
    }

    bfs()
    println(sb)
}

private fun bfs(){
    val que = PriorityQueue<Int>()
    indegree.forEachIndexed{ index,i ->
        if(index!=0&&i==0)que.add(index)
    }
    while(que.isNotEmpty()){
        val temp = que.poll()
        sb.append("$temp ")

        for(i in arr[temp]){
            if(--indegree[i]==0){
                que.add(i)
            }
        }
    }
}