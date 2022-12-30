package BOJ.Silver

import java.util.*


private lateinit var arr:Array<CharArray>
private lateinit var visited:Array<BooleanArray>
var o=0
var v=0
val dis = Array(4){IntArray(2)}.apply{
    this[0]=intArrayOf(0,-1)
    this[1]=intArrayOf(0,1)
    this[2]=intArrayOf(1,0)
    this[3]=intArrayOf(-1,0)
}
fun main() {

    val (r,c) = readln().split(" ").map{it.toInt()}
    arr = Array(r){CharArray(c)}.apply{
        repeat(r){
            this[it]=readln().toCharArray()
        }
    }
    visited = Array(r){BooleanArray(c)}
    //bfs
    for(i in 0 until r){
        for(j in 0 until c){
            if(visited[i][j])continue
            bfs(i,j)
        }
    }
    println("${o} ${v}")
}

private fun bfs(i:Int,j:Int) {
    var to= 0
    var tv= 0
    val que = LinkedList<Pair<Int,Int>>()
    que.add(Pair(i,j))
    visited[i][j]=true

    while(que.isNotEmpty()){
        val temp = que.poll()

        for(i in dis){
            val nx = temp.first+ i[0]
            val ny = temp.second+i[1]

            if(nx<0||ny<0||nx>=arr.size||ny>=arr[0].size)continue
            if(visited[nx][ny])continue
            if(arr[nx][ny]=='#')continue

            if(arr[nx][ny]=='o')to++
            else if(arr[nx][ny]=='v')tv++

            visited[nx][ny]=true
            que.add(Pair(nx,ny))
        }
    }

    if(to>tv)o+=to
    else v+=tv
}