package BOJ.gold

import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr = Array(n){ IntArray(3) }
    val dp = Array(n){ IntArray(3) }
    var answer = Int.MAX_VALUE

    repeat(n){arr[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()}
    for(j in 0 until 3){
        for(i in 0 until 3){
            if(j==i)dp[0][i] = arr[0][i]
            else dp[0][i] = 1000 * n +1
        }
        for(i in 1 until n){
            dp[i][0] = min(dp[i-1][1],dp[i-1][2])+arr[i][0]
            dp[i][1] = min(dp[i-1][0],dp[i-1][2])+arr[i][1]
            dp[i][2] = min(dp[i-1][0],dp[i-1][1])+arr[i][2]
        }
        for(i in 0 until 3){
            if(j!=i) answer = min(answer,dp[n-1][i])
        }
    }


    println(answer)

}