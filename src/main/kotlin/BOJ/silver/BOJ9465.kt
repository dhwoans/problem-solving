package BOJ.silver

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    repeat(t){
        val n = br.readLine().toInt()
        val arr = Array(2){ IntArray(n) }
        var dp  = Array(2){ IntArray(n) }
        repeat(2){ arr[it]=br.readLine().split(" ").map { it.toInt() }.toIntArray()}

        dp[0][0]=arr[0][0]
        dp[1][0]=arr[1][0]

        if(n>1){
            dp[0][1]=arr[1][0]+arr[0][1]
            dp[1][1]=arr[0][0]+arr[1][1]

            for(i in 2 until n){
                dp[0][i]=max(max(dp[0][i-2],dp[1][i-2]),dp[1][i-1])+arr[0][i]
                dp[1][i]=max(max(dp[0][i-2],dp[1][i-2]),dp[0][i-1])+arr[1][i]
            }
        }
        println(max(dp[0][n-1],dp[1][n-1]))
    }
}