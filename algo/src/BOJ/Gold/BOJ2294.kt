import kotlin.math.min

fun main() {
    val (n,k)= readLine()!!.split(" ").map(String::toInt)
    val arr = IntArray(n).apply{
        repeat(n){
            this[it] = readLine()!!.toInt()
        }
        this.sort()
    }
    val dp = IntArray(k+1){100001}
    dp[0]=0

    for(i in arr){
        for(j in i .. k){
            dp[j] = min(dp[j], dp[j - i] + 1);
        }
    }
    if(dp[k]==100001)println(-1)else println(dp[k])
}