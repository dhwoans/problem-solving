package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val (d,t) = readln().split(" ").map(String::toInt)
    var  dow = readln().toInt()
    var max = dow/d
    val que = PriorityQueue<Int>{o1,o2->o2-o1}
    repeat(n){
        que.add(readln().toInt())
    }
    var num =1
    while(que.isNotEmpty()){
        val temp = que.poll()
        dow+=temp
        (dow/(d+t*num)).takeIf{it>max}?.let{max=it}
        num++
    }
    println(max)
}