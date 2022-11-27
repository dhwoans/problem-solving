package BOJ

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val arr = IntArray(9)

    for (i in 0 until arr.size) {
        arr[i] = readLine()!!.toInt()
    }
    var max = Int.MIN_VALUE
    for (i in arr) {
        max = Math.max(max, i)
    }
    println(max)
    print(arr.indexOf(max)+1)
}