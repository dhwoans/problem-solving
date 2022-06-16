package BOJ

import java.io.BufferedReader

fun main()= with(BufferedReader(System.`in`.bufferedReader())) {
    val n = readLine()!!.toInt()
    for (i in n downTo 1){
        println(i)
    }
}