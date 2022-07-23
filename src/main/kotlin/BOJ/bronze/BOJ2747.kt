package BOJ

private lateinit var dp:IntArray

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    dp = IntArray(n+1).apply{
        this[0]=0
        this[1]=1
        if(this.size>2)this[2]=1
    }
    println(fibo(n))
}

private fun fibo(n:Int): Int {
    if(dp[n]!=0) return dp[n]
    dp[n]=fibo(n-1)+fibo(n-2)
    return dp[n]
}
