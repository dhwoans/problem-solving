package BOJ.Gold

import java.util.*
import kotlin.collections.ArrayList

private var ans = 0
fun main() {
    val n = readln().toInt()
    val color = intArrayOf(0)+readln().split(" ").map{it.toInt()}.toIntArray()
    val visited = BooleanArray(n+1)
    val arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n+1){
            this.add(ArrayList<Int>())
        }
        //간선 정보
        repeat(n-1){
            val (from,to)   = readln().split(" ").map{it.toInt()}
            this[from].add(to)
            this[to].add(from)
        }
    }
    //dfs
    visited[1]=true
    search(1,color[1],color,visited,arr)
    if(color[1]!=0)ans++
    println(ans)
}
private fun search(next:Int,currentColor:Int,color:IntArray,visited:BooleanArray,arr:ArrayList<ArrayList<Int>>){
    for(i in arr[next]){
        if(visited[i])continue
        visited[i]=true
        if(currentColor!=color[i]){
            ans++
            search(i,color[i],color,visited,arr)
        }else{
            search(i,currentColor,color,visited,arr)
        }

    }
}