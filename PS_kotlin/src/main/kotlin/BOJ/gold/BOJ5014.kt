package BOJ

import java.util.LinkedList

fun main() {
    val br = System.`in`.bufferedReader()
    val (f,s,g,u,d) = br.readLine().split(" ").map{ it.toInt() }
    val visited = BooleanArray(f+1)
    val que = LinkedList<IntArray>()
    que.add(intArrayOf(0,s))

    while (que.isNotEmpty()){
        val temp = que.poll()
        if(visited[temp[1]])continue
        visited[temp[1]]= true
        if(temp[1]==g){
            println(temp[0])
            return
        }
        if(temp[1]+u<visited.size&&!visited[temp[1]+u]){
//            visited[temp[1]+u]= true
            que.add(intArrayOf(temp[0]+1 ,temp[1]+u))
        }
        if(temp[1]-d>0&&!visited[temp[1]-d]){
//            visited[temp[1]-d]= true
            que.add(intArrayOf(temp[0]+1, temp[1]-d))
        }
    }
    println("use the stairs")
}