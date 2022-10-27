package BOJ.silver

import java.io.BufferedReader
import kotlin.math.max

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()
    val arr = IntArray(n+1)
    var dp = IntArray(n+1)

    for (i in 1 until arr.size){
        arr[i] = readLine().toInt()
    }

    dp[1]=arr[1]
    if(n>1) dp[2]=arr[1]+arr[2]

    for (i in 3 until arr.size ){
        dp[i]= max(dp[i-1],max(dp[i-2]+arr[i],dp[i-3]+arr[i-1]+arr[i]))
    }
    println(dp[n])
}