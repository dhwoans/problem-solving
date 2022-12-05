package BOJ.Silver

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val n = readln().toInt()
    val arr = ArrayList<ArrayList<Int>>().apply {
        repeat(n) {
            this.add(ArrayList<Int>())
        }
        repeat(n - 1) {
            val (from, to) = readln().split(" ").map { it.toInt()-1 }
            this[from].add(to)
            this[to].add(from)
        }
    }
    //bfs
    val visited = BooleanArray(n)
    val que = LinkedList<Int>()
    que.add(0)
    visited[0]=true
    var count =-1
    var sum =0
    while(que.isNotEmpty()){
        val turn = que.size
        count++
        repeat(turn){
            val temp = que.poll()
            var flag =true
            for (next in arr[temp]) {
                if (visited[next]) continue
                visited[next] = true
                flag =false
                que.add(next)
            }
            if(flag)sum+=count
        }
    }
    //판단
    if(sum%2==0){
        println("No")
    }else{
        println("Yes")
    }
}