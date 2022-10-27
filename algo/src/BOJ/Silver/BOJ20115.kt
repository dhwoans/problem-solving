package BOJ.silver

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map(String::toDouble).toDoubleArray()
    arr.sort()
   repeat(n-1){
       arr[it] = arr[it]/2
   }

    println(arr.sum())
}