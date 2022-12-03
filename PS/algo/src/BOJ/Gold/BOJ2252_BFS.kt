package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var indegree:IntArray
private lateinit var answer:ArrayList<Int>

fun main() {
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    arr = ArrayList()
    indegree = IntArray(n+1)
    answer = ArrayList()

    //인접리스트
    repeat(n+1){arr.add(ArrayList())}
    //간선 체크
    repeat(m){
        val (start,end) = readLine()!!.split(" ").map{it.toInt()}
        arr[start].add(end)
        indegree[end]++
    }
    //bfs
    bfs()
    answer.forEach{ print("${it} ")}
}
private fun bfs(){
    val que = LinkedList<Int>()

    indegree.forEachIndexed{index,i->
        if(index!=0&&i==0){
            que.add(index)
        }
    }
    while(que.isNotEmpty()){
        val n = que.poll()
        answer.add(n)
        for(i in arr[n]){
            if(--indegree[i]==0){
                que.add(i)
            }
        }
    }
}