package BOJ.bronze

import java.io.BufferedReader
import java.lang.Math.pow
import kotlin.math.PI

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val r = readLine()
    val r2 = pow(r.toDouble(), 2.0)
    println("%.06f".format(r2* PI))
    println("%.06f".format(r2* 2))
}