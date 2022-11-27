package BOJ.gold

import java.util.*
import kotlin.math.max

private lateinit var arr:Array<IntArray>
private lateinit var visited:Array<IntArray>
private val dir = Array(4){IntArray(2)}.apply{
    this[0] = intArrayOf(0,-1)  //서
    this[1] = intArrayOf(-1,0)  //북
    this[2] = intArrayOf(0,1)  //동
    this[3] = intArrayOf(1,0)  //남
}

private var count = 1
private var size = 0

fun main() {
    val (m,n)= readLine()!!.split(" ").map(String::toInt)
    arr = Array(n){IntArray(m)}
    visited = Array(n){IntArray(m)}
    val max = IntArray(25012)
    var join =0
    repeat(n){
        arr[it] =  readLine()!!.split(" ").map(String::toInt).toIntArray()
    }

    for(i in  0 .. arr.lastIndex){
        for(j in 0 .. arr[i].lastIndex){
            if(visited[i][j]==0) {
                size=0
                bfs(i,j)
                max[count++]=size
            }
        }
    }
    println(count-1)
    println(max.maxOrNull())

    for(i in 0 ..arr.lastIndex){
        for(j in 0 .. arr[i].lastIndex){

            for(k in 0 .. 3){
                val nx = i + dir[k][0]
                val ny = j + dir[k][1]

                if(nx<0||ny<0||nx>=arr.size||ny>=arr[0].size)continue
                if(visited[i][j]!=visited[nx][ny]){
                    join = max(join, max[visited[i][j]]+max[visited[nx][ny]])
                }
            }
        }
    }
    println(join)
}

private fun bfs(x:Int,y:Int){
    val que = LinkedList<IntArray>()
    que.add(intArrayOf(x,y))
    visited[x][y]=count

    while(que.isNotEmpty()){
        val temp = que.poll()
        size++

        for(i in 0..3){

            if(arr[temp[0]][temp[1]] and (1 shl i)==(1 shl i))continue  //벽체크
            val nx = temp[0] + dir[i][0]
            val ny = temp[1] + dir[i][1]

            if(visited[nx][ny]!=0)continue //방문
            visited[nx][ny] = count
            que.add(intArrayOf(nx,ny))
        }
    }
}