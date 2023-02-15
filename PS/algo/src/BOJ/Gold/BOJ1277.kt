package BOJ.Gold

import java.util.*
import kotlin.collections.ArrayList
import kotlin.math.sqrt

fun main() {
    val (n,w) = readln().split(" ").map{it.toInt()}
    val m:Double = readln().toDouble()
    val xy = ArrayList<Pair<Int,Int>>()
    val arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n){
            this.add(ArrayList<Int>())
        }
    }
    val temp= IntArray(3)

    //발전소 위치
    repeat(n){
        val (x,y)=readln().split(" ").map{it.toInt()}
        xy.add(Pair(x,y))
    }
    //연결된 발전소
    repeat(w){
        val (f,t) = readln().split(" ").map{it.toInt()-1}
        arr[f].add(t)
        arr[t].add(f)
    }
    //bfs
    val visited = DoubleArray(n){987654321.0}
    val que = PriorityQueue<Info1>(compareBy { it.len })
    que.add(Info1(xy[0].first,xy[0].second,0,0.0))
    visited[0]=0.0
    while(que.isNotEmpty()){
        val temp = que.poll()
        if(temp.node==n-1){
            println((temp.len*1_000).toInt())
            return
        }
        //이어진 발전소
        for(i in arr[temp.node]){
            if(visited[i]<=temp.len)continue
            visited[i]=temp.len
            que.add(Info1(xy[i].first,xy[i].second,i,temp.len))
        }
        //안이어진 발전소
        for(i in 0 until xy.size){
            if(i==temp.node)continue
            val length =sqrt((temp.x-xy[i].first).toDouble()*(temp.x-xy[i].first).toDouble()+(temp.y-xy[i].second).toDouble()*(temp.y-xy[i].second).toDouble())
            if(length<=m){
                if(visited[i]<=temp.len+length)continue
                visited[i]=temp.len+length
                que.add(Info1(xy[i].first,xy[i].second,i,temp.len+length))
            }
        }
    }
}
private data class Info1(val x:Int, val y:Int, val node:Int, val len:Double)
