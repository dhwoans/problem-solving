package BOJ.gold

import kotlin.math.max

fun main() {
    val (n,m) =readLine()!!.split(" ").map(String::toInt)
    val dp = Array(m){IntArray(n)}
    val arr = Array(m){IntArray(n)}.apply{
        repeat(m){
            this[it]=readLine()!!.split(" ").map(String::toInt).toIntArray()
        }
    }

    for(i in 0 until m){
        dp[i][0] = arr[i][0]
    }

    for(i in  1 until n){
        for(j in 0 until m){
            for(k in 0 until m){
                if(j == k){
                    dp[j][i]= max(dp[j][i],dp[k][i-1]+arr[j][i]/2)
                }else{
                    dp[j][i]= max(dp[j][i],dp[k][i-1]+arr[j][i])
                }
            }
        }
    }
    var max =0
    for(i in 0 until m){
        max = max(max,dp[i][n-1])
    }
    println(max)
}