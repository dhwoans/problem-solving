package BOJ.Silver

fun main() {
    val  n = readln().toInt()
    val dp  = IntArray(100_001)
    dp[1]=3
    dp[2]=7
    dp[3]=17
    for(i in 4 until dp.size){
        dp[i]=(dp[i-1]*2+dp[i-2])%9901
    }
    println(dp[n])
}