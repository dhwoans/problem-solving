package BOJ.bronze

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()

    for (i in 0 .. n){
        var answer = i.toString().map { it.code - '0'.code }.sum()
        if(i+answer == n){
            println(i)
            return
        }
    }
    println(0)
}