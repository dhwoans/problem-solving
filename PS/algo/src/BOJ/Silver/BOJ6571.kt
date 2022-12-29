package BOJ.Silver

import java.math.BigInteger


val dp = Array<BigInteger>(1_001){0.toBigInteger()}

fun main() {
    dp[1]= 1.toBigInteger()
    dp[2]= 2.toBigInteger()
    for(i in 3 until dp.size){
        dp[i]= dp[i-1]+dp[i-2]
    }
    while (true) {
        val (n, m) = readln().split(" ").map { it.toBigInteger() }
        if(n==0.toBigInteger()&&m==0.toBigInteger())break
        var ans =0
        for(i in 1 until dp.size){
            if(dp[i] in n..m){
                ans++
            }
        }
        println(ans)
    }
}