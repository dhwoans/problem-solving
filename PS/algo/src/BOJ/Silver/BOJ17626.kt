package BOJ.Silver

import kotlin.math.min
import kotlin.math.sqrt

fun main() {
    val n = readln().toInt()
    val arr = IntArray( 50_001)
    arr[1]=1
    for(i in 1 .. n){
        arr[i]=arr[1]+arr[i-1]
        for(j in 2 ..sqrt(i.toDouble()).toInt()){
            arr[i]=min(arr[i],1+arr[i-j*j])
        }
    }
    println(arr[n])
}