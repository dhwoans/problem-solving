package BOJ.Gold

import java.util.*

private lateinit var node:ArrayList<ArrayList<Int>>
private lateinit var visited:BooleanArray

fun main() {
    val (r,c)= readln().split(" ").map(String::toInt)
    node = ArrayList<ArrayList<Int>>().apply{
        repeat(r*c){
            this.add(ArrayList())
        }
    }
    val arr = Array(r){CharArray(c)}.apply{
        repeat(r){
            this[it]= readln().toCharArray()
        }
    }

    //간선 만들기
    for(i in 0 until r){
        for(j in 0 until c){
            var nx = i
            var ny = j
            when(arr[i][j]) {
                'U' -> {
                    nx -= 1
                }
                'D' -> {
                    nx += 1
                }
                'L' -> {
                    ny -= 1
                }
                'R' -> {
                    ny += 1
                }
            }
            node[c*i+j].add(c*nx+ny)
            node[c*nx+ny].add(c*i+j)
        }
    }
    visited =BooleanArray(r*c)
    var count =0
    for(i in 0 until r*c){
        if(visited[i])continue
        visited[i]=true
        bfs(i)
        count++
    }
    println(count)
}

private fun bfs(x:Int){
    val que = LinkedList<Int>()
    que.add(x)
    while(que.isNotEmpty()){
        val temp = que.poll()

        for(i in node[temp]){
            if(visited[i])continue
            visited[i]=true
            que.add(i)
        }

    }
}