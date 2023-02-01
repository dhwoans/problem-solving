package BOJ.Silver

import java.util.*

fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    val count = HashMap<Int,Int>()
    val indx = HashMap<Int,Int>()
    val que  = PriorityQueue<Triple<Int,Int,Int>>(compareBy( { -it.second },{it.third}))
    readln().split(" ").map{it.toInt()}.forEachIndexed { index, i ->
        if(indx[i]==null){
            indx[i]=index
        }
        count[i] = count.getOrDefault(i,0)+1
    }
    for(i in count.keys){
            que.add(Triple(i,count[i]!!,indx[i]!!))
    }
    val sb = StringBuilder()
    while(que.isNotEmpty()){
        val temp  = que.poll()
        repeat(temp.second ){
            sb.append("${temp.first} ")
        }
    }
    println(sb)
}
