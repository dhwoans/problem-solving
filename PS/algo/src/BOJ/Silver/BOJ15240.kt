package BOJ.Silver

import java.util.*

fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    val dir = Array(4){IntArray(2)}.apply{
        this[0]=intArrayOf(0,-1)
        this[1]=intArrayOf(0,1)
        this[2]=intArrayOf(1,0)
        this[3]=intArrayOf(-1,0)
    }
    val arr = Array(n){IntArray(m)}
    repeat(n){i ->
        arr[i]=readln().map{it-'0'}.toIntArray()
    }

    val (x,y,num)=readln().split(" ").map{it.toInt()}
    val que = LinkedList<IntArray>()
    que.add(intArrayOf(x,y))
    val visited = Array(n){BooleanArray(m)}
    val check = arr[x][y]
    visited[x][y]=true
    arr[x][y]=num

    while(que.isNotEmpty()){
        val temp = que.poll()
        for(i in dir){
            val nx= temp[0] + i[0]
            val ny= temp[1] + i[1]

            if(nx<0||ny<0||nx>=n||ny>=m)continue
            if(visited[nx][ny])continue
            if(arr[nx][ny]!=check)continue
            visited[nx][ny]=true
            arr[nx][ny]=num
            que.add(intArrayOf(nx,ny))
        }
    }
    val sb = StringBuilder()
    for(i in arr){
        for(j in i){
            sb.append(j)
        }
        sb.appendLine()
    }
    println(sb)
}