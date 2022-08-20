package BOJ.silver

import java.io.BufferedReader
import java.lang.StringBuilder

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val a = readLine().split(" ").map { it.toInt() }.toIntArray()
    val b = readLine().split(" ").map { it.toInt()}.toIntArray()
    val sb = StringBuilder()
    a.plus(b).sortedArray().forEach { sb.append(it).append(" ") }
    println(sb)
}