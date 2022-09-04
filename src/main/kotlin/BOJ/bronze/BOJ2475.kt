package BOJ.bronze

import java.io.BufferedReader
import java.lang.Math.pow


fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val arr = readLine().toString().split(" ").map { pow(it.toDouble(), 2.0).toInt() }.sum()
    println(arr%10)
}