package BOJ.Gold

import kotlin.math.max
import kotlin.math.min

private lateinit var arr:IntArray
fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    arr = readln().split(" ").map{it.toInt()}.toIntArray()
    var hi = arr.max()
    var ro = 0

    while(ro<hi){
        val mid = (ro+hi)/2
        if(check(mid,m)){
            hi = mid
        }else{
            ro = mid +1
        }
    }
    println(ro)
}
private fun check(mid:Int,m:Int):Boolean {
    var count =1
    var turn =0
    var max =Int.MIN_VALUE
    var min =Int.MAX_VALUE

    while(turn<arr.size){
        max = max(max,arr[turn])
        min = min(min,arr[turn])
        if(max-min>mid){
            max=Int.MIN_VALUE
            min=Int.MAX_VALUE
            count++
            turn--
        }
        turn++
    }
    return count<=m
}