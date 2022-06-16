package BOJ

import java.io.BufferedReader

fun main()= with(BufferedReader(System.`in`.bufferedReader())) {
    val n:Int = readLine()!!.toInt()
    val arr  = readLine()!!.toString().split(" ").map { it -> it.toInt() }.toIntArray();

    println("${arr.minOrNull()} ${arr.maxOrNull()}")
}