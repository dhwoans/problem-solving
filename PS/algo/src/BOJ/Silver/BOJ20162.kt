package BOJ.Silver

import kotlin.math.max

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n)
    val dp = IntArray(n)
    repeat(n){
        arr[it]=readln().toInt()
    }
    dp[0]=arr[0]
    for(i in 1 until arr.size){
        var temp = 0
        for(j in 0 until i){
            if(arr[i]>arr[j]) temp = max(temp,dp[j])
        }
        dp[i]=arr[i]+temp
    }
    println(dp.max())
}