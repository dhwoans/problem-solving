package BOJ.silver

import java.io.BufferedReader

fun main()=with(BufferedReader(System.`in`.bufferedReader())) {
    val s = readLine()
    val arr =Array(s.length) { s.substring(it, s.length) }.sortedArray().forEach { println(it)}

}