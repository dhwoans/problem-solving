package BOJ.gold

import java.util.*
import kotlin.math.max

private lateinit var degree:IntArray
private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var cost:IntArray
private lateinit var answer:IntArray

fun main() {
    val n = readLine()!!.toInt()
    degree = intArrayOf(0)+IntArray(n)
    cost = intArrayOf(0)+IntArray(n)
    answer = intArrayOf(0)+IntArray(n)

    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n+1){
            this.add(ArrayList<Int>())
        }
    }

    repeat(n){
        val info = readLine()!!.split(" ").map(String::toInt).toIntArray()
        cost[it+1]=info[0]
        for(i in 1 until info.lastIndex){
            arr[info[i]].add(it+1)
            degree[it+1]++
        }
    }
    topologySort()
    answer.forEachIndexed{index, i -> if(index!=0) println(i)}
}

private fun topologySort(){
    val que = LinkedList<Int>()
    degree.forEachIndexed{index,i ->
        if(index!=0&&i==0)que.add(index)
        answer[index]= cost[index]
    }
    while(que.isNotEmpty()){
        val temp = que.poll()

        arr[temp].forEach{
            answer[it] = max(answer[it],answer[temp]+cost[it])
            if(--degree[it]==0){
                que.add(it)
            }
        }
    }
}
