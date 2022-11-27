package BOJ.gold

import java.util.PriorityQueue

private val size = 100_001
fun main() {
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    val visited =  BooleanArray(size){false}
    val que = PriorityQueue<info>()

    que.add(info(n,0))
    visited[n]=true

    while(que.isNotEmpty()){
        val z:info = que.poll()
        visited[z.pos]=true

        if(z.pos==k) return println(z.cost)

        if(z.pos * 2<size && !visited[z.pos * 2] ) que.add(info(z.pos * 2,z.cost))
        if(z.pos-1>=0 && !visited[z.pos-1]) que.add(info(z.pos-1,z.cost+1))
        if(z.pos+1<size && !visited[z.pos+1]) que.add(info(z.pos+1,z.cost+1))

    }

}

private data class info(val pos:Int,val cost:Int): Comparable<info>{
    override fun compareTo(other: info): Int {
        return cost-other.cost
    }
}