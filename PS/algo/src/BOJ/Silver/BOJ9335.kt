package BOJ.Gold

import kotlin.math.min

private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var visited:BooleanArray
private var count = Int.MAX_VALUE
fun main() {
    repeat(readln().toInt()){
        count = Int.MAX_VALUE
        val n = readln().toInt()
        arr = ArrayList<ArrayList<Int>>()
        repeat(n){
            arr.add(ArrayList())
            val temp = readln().split(" ").map{it.toInt()}.toIntArray()
            for(i in 0 until temp[0]){
                arr[it].add(temp[i+1])
            }
        }
        visited = BooleanArray(n)
        powerset(0,arr.size,n)
        println(count)

    }
}

private fun powerset(cnt:Int,m:Int,n:Int){
    if(cnt==m){
        cal(n)
        return
    }
    visited[cnt]=true
    powerset(cnt+1,m,n)
    visited[cnt]=false
    powerset(cnt+1,m,n)
}
private fun cal(n:Int){
    val ans = BooleanArray(n)
    for(i in visited.indices){
        if(visited[i]){
            ans[i]=true
            for(j in arr[i]){
                ans[j-1]=true
            }
        }
    }
    if(ans.count{!it}==0) count = min(count,visited.count{it})
    return
}