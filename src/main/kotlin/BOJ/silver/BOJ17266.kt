package BOJ.silver

import kotlin.math.abs
import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val t = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    arr.sort()
    val dis = intArrayOf(0) + arr + intArrayOf(n)
    var answer = 0
    for(i in 1 until dis.size ){
        var abs = abs(dis[i]-dis[i-1])
        if(i!=1 && i!=dis.size-1) {
            if(abs%2!=0)abs+=1
            abs /=2
        }

        answer = max(answer, abs)

    }
    println(answer)
}