package BOJ.silver

import java.util.*
import kotlin.collections.HashMap

fun main() {
    val n = readLine()!!.toInt()
    val map = HashMap<Int,Int>()
    val que = PriorityQueue <Triple<Int,Int,Int>>{a,b -> b.third.compareTo(a.third)}
    repeat(n){
        val (cou,num,sco) = readLine()!!.split(" ").map(String::toInt)
        que.add(Triple(cou,num,sco))
        map.putIfAbsent(cou,2)
    }
    var count =0
    while(que.isNotEmpty()){
        if(count==3)break
        val temp = que.poll()
        if(map[temp.first]==0)continue
        else {
            count++
            map[temp.first] = map[temp.first]!! -1
            println("${temp.first} ${temp.second}")
        }
    }
}