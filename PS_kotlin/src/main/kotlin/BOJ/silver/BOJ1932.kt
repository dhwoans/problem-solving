package BOJ

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val n  = br.readLine().toInt()
    val dp = Array(n){IntArray(n)}
    val arr = Array(n){IntArray(n)}
    repeat(n){
        arr[it]=br.readLine().split(" ").map{it.toInt() }.toIntArray()
    }
    dp[0][0]=arr[0][0]
    for(i in 0 until arr.size-1){
        for(j in 0 .. i){
            dp[i+1][j] = max(dp[i+1][j],dp[i][j]+arr[i+1][j])
            dp[i+1][j+1] =max(dp[i+1][j+1],dp[i][j]+arr[i+1][j+1])
        }
    }
    println(dp[n-1].maxOrNull())
}