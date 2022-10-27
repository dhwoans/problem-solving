package BOJ.silver

import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val jump = Array(22) { IntArray(2) }.apply {
        repeat(n-1) {
            val (s, b) = readLine()!!.split(" ").map(String::toInt)
            this[it] = intArrayOf(s, b)
        }
    }
    val bigJump = readLine()!!.toInt()
    val dp = Array(22){IntArray(2){987654321}}
    dp[0][0]=0
    dp[1][0]=jump[0][0]
    dp[2][0]=min(jump[0][1],jump[1][0]+jump[0][0])

    for(i in 3 until n){
        dp[i][0] = min(jump[i-1][0]+dp[i-1][0],jump[i-2][1]+dp[i-2][0])
        dp[i][1]= min(min(jump[i-1][0]+dp[i-1][1],jump[i-2][1]+dp[i-2][1]),bigJump+dp[i-3][0])
    }
    println(min(dp[n-1][0],dp[n-1][1]))
}