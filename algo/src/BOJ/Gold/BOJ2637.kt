package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:ArrayList<ArrayList<Pair<Int,Int>>>
private lateinit var indegree:IntArray
private lateinit var cost:IntArray

fun main() {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()
    indegree = IntArray(n+1)
    cost = IntArray(n+1)
    arr = ArrayList<ArrayList<Pair<Int,Int>>>().apply{
        repeat(n+1){
            this.add(ArrayList())
        }

        repeat(m){
            val(from,to,cost) = readLine()!!.split(" ").map(String::toInt)
            this[from].add(Pair(to,cost))
            indegree[to]++
        }
    }
    val answer=topologysort(n)
    answer.sortBy{it.first}
    answer.forEach{ println("${it.first} ${it.second}")}

}

private fun topologysort(n:Int):ArrayList<Pair<Int,Int>>{
    val answer = ArrayList<Pair<Int,Int>>()
    val que = LinkedList<Pair<Int,Int>>()
    que.add(Pair(n,1))

    while(que.isNotEmpty()){
        val temp = que.poll()

        if(arr[temp.first].size==0)answer.add(temp)

        for(i in arr[temp.first]){
            cost[i.first]+=i.second*temp.second

            if(--indegree[i.first]==0){
                que.add(Pair(i.first,cost[i.first]))
            }
        }
    }
    return answer
}