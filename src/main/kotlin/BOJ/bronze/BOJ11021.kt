package BOJ.bronze

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()
    for(i in 1..n){
        val (num1,num2) = readLine().split(" ").map{it.toInt()}
        println("Case #${i}: ${ num1 + num2}")
    }
}