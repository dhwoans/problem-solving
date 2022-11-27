package BOJ.bronze

import java.io.BufferedReader
import java.text.DecimalFormat
import kotlin.math.round

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val t = readLine().toInt()
    repeat(t){
        val temp= readLine().split(" ").map { it.toInt() }.toIntArray()
        val size = temp[0]
        val div = temp.copyOfRange(1,size+1).sum().div(size)
        val answer = temp.copyOfRange(1, size+1).count { it > div }.toDouble().div(size).times(100)
        println("${DecimalFormat("0.000").format(round(answer*1000)/1000)}%")

    }
}