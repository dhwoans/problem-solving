package codeforces

import kotlin.math.max
import kotlin.math.min

private lateinit var visited:BooleanArray
private lateinit var cats:IntArray
private lateinit var arr:ArrayList<ArrayList<Int>>
private var count =0




fun main() {
    val (n,m) = readln().split(" ").map(String::toInt)
    cats = readln().split(" ").map(String::toInt).toIntArray()
    visited = BooleanArray(n);
    arr =ArrayList<ArrayList<Int>>().apply{
        repeat(n){
            this.add(ArrayList())
        }
        repeat(n-1){
            val(from,to) = readln().split(" ").map(String::toInt)

            this[from-1].add(to-1)
            this[to-1].add(from-1)

        }
    }
    visited[0]=true
    dfs(0,cats[0],m)
    println(count)
}

private fun dfs(start:Int,cat:Int,m:Int) {
    if(cat>m)return
    var flag=true
    for(i in arr[start]){
        if(visited[i])continue
        flag= false
        visited[i]=true
        if(cats[i]==0){
            dfs(i,0,m)
        }else{
            dfs(i,cat+cats[i],m)
        }
    }
    if(flag){
        count++
    }
    return
}