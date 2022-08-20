package BOJ.silver

import kotlin.math.max

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    val dp = IntArray(n)
    for(i in arr.indices){
        dp[i]=1
        for(j in 0 until i){
            if(arr[i]>arr[j])dp[i]=max(dp[i],dp[j]+1)
        }
    }
    val answer = dp.maxOrNull()
    println(answer)
}