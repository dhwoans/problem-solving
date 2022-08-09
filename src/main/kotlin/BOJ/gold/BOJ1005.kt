package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.max

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var indegree: IntArray
private lateinit var cost: IntArray
private lateinit var time: IntArray
private val sb = StringBuilder()

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {

        val (n,k) = readLine()!!.split(" ").map { it.toInt() }
        cost = readLine()!!.split(" ").map { it.toInt() }.toIntArray()

        indegree = IntArray(n + 1)
        arr = ArrayList<ArrayList<Int>>().apply {
            //인접리스트 생성
            repeat(n + 1) { this.add(ArrayList()) }
            //간선 추가
            repeat(k) {
                val (start, end) = readLine()!!.split(" ").map { it.toInt() }
                this[start].add(end)
                indegree[end]++
            }
        }
        //완성 건물
        val complete = readLine()!!.toInt()
        time = IntArray(n+1)
        bfs()
        sb.appendLine(time[complete])
    }
    println(sb)
}

private fun bfs() {
    val que = LinkedList<Int>()
    for (i in 1 until indegree.size) {
        if (indegree[i] == 0) {
            que.add(i)
            time[i]=cost[i-1]
        }
    }
    while (que.isNotEmpty()) {
        val temp = que.poll()

        for (i in arr[temp]) {
            time[i] = max(time[i],time[temp]+cost[i-1])
            if (--indegree[i] == 0) que.add(i)
        }
    }
}