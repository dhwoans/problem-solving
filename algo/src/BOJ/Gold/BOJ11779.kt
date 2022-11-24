package BOJ.Gold

import java.util.*
import kotlin.collections.ArrayList


private lateinit var arr:ArrayList<ArrayList<N>>

fun main() {
    val n = readln().toInt()
    arr = ArrayList<ArrayList<N>>().apply{
        repeat(n){
            this.add(ArrayList())
        }
    }
    //간선 정보
    repeat(readln().toInt()){
        val (from,to,cost) = readln().split(" ").map{it.toInt()-1}
        arr[from].add(N(to,cost+1,0))

    }
    //출발 도착
    val (start,end)= readln().split(" ").map{it.toInt()-1}
    //dij
    val visited = IntArray(n){987654321}
    val check = IntArray(n)
    val count = IntArray(n)
    val que = PriorityQueue<N>(compareBy { it.cost })
    que.add(N(start,0,1))
    visited[start]=0

    while(que.isNotEmpty()){
        val temp = que.poll()

        if(visited[temp.to]<temp.cost)continue

        for(next in arr[temp.to]){
            if(visited[next.to]>next.cost+temp.cost){
                visited[next.to]=next.cost+temp.cost
                check[next.to]=temp.to
                count[next.to]=temp.count+1
                que.add(N(next.to,next.cost+temp.cost,temp.count+1))
            }
        }

    }
    //최단거리
    println(visited[end])
    //방문 도시 수
    println(count[end])
    //역추적
    val stack = Stack<Int>()
    var track = end
    stack.push(track)
    while(track!=start){
        track = check[track]
        stack.push(track)
    }

    while(stack.isNotEmpty()){
        print("${stack.pop()+1} ")
    }
}

private data class N(val to:Int, val cost:Int,val count:Int)