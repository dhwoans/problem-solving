package BOJ.Gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr:ArrayList<ArrayList<Int>>
private var sum:Double = 0.0
private var leaf =0

fun main() {
    val (v,w) =readln().split(" ").map(String::toInt)
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(v){
            this.add(ArrayList<Int>())
        }
        repeat(v-1){
            val (from,to) = readln().split(" ").map{it.toInt()-1}
            this[from].add(to)
            this[to].add(from)
        }
    }
    bfs(v,w.toDouble())
    println(sum/leaf)
}

private fun bfs(v:Int,w:Double) {
    val visited = BooleanArray(v)
    visited[0]=true
    val que:Queue<Pair<Int,Double>> = LinkedList()
    que.add(Pair(0,w))
    while(que.isNotEmpty()){
        val temp = que.poll()

        val next = ArrayList<Int>()
        for(i in arr[temp.first]){
            if(visited[i]) continue
            visited[i]=true
            next.add(i)
        }
        if( next.size==0){
            sum +=temp.second
            leaf++
        }else{
            for(i in next){
                que.add(Pair(i,temp.second/next.size))
            }
        }
    }

}

