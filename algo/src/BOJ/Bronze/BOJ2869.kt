package BOJ.bronze

import java.io.BufferedReader

fun main()= with(BufferedReader(System.`in`.bufferedReader())) {
    val (a,b,v) =readLine().split(" ").map { it.toInt() }
    val n = a-b
    val m =v -a
    if(m%n==0) println(m/n+1)
    else println(m/n+2)
}