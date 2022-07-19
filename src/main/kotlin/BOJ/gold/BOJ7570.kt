package BOJ.silver


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var dp = IntArray(n+1)
    br.readLine().split(" ").map{it.toInt()}.forEach {
        dp[it]=dp[it-1]+1
    }
    println(n- dp.maxOrNull()!!)
}