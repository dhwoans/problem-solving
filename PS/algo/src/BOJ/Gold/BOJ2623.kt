package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var indegree:IntArray
private val sb  = StringBuilder()

fun main() {
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    indegree = IntArray(n+1)
    //간선 만들기
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n+1){this.add(ArrayList())}

        repeat(m){
            val map = readLine()!!.split(" ").map(String::toInt).toIntArray()
            for(i in 1 until map.lastIndex){
                this[map[i]].add(map[i+1])
                indegree[map[i+1]]++
            }
        }
    }
    val count=bfs()
    if(count==n) println(sb) else println(0)
}

private fun bfs():Int{
    var count =0
    val que = LinkedList<Int>()
    indegree.forEachIndexed { index, i ->
        if(index!=0 && i==0){
            que.add(index)
            count++
        }

    }
    while(que.isNotEmpty()){
        val temp = que.poll()

        sb.appendLine(temp)

        for(i in arr[temp]){
            if(--indegree[i]==0){
                que.add(i)
                count++
            }
        }
    }
    return count
}