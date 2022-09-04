package BOJ.gold

import kotlin.math.abs
import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val (x,y,c) = readLine()!!.split(" ").map(String::toDouble)
    var left:Double =0.0
    var right:Double = min(x,y)

    while(true){
        val mid:Double  = (left+right)/2
        val x1 = sqrt(x*x-mid*mid)
        val y1 = sqrt(y*y-mid*mid)
        val c1 = (x1*y1)/(x1+y1)
        if(abs(c1-c)<=0.001){
            println(mid)
            return
        }
        if(c1>c)left = mid
        else right = mid
    }
}