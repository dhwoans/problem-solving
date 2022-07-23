package BOJ.gold

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m)= br.readLine().split(" ").map { it.toInt() }
    val dp = Array(m+1){LongArray(n+1)}

    (0 .. n).forEach{dp[1][it]=1}

    for(i in 2 .. m){
        var sum = 0L
        for(j in 0 .. n){
            sum +=dp[i-1][j]
            dp[i][j]= sum % 1_000_000_000

        }
    }
    println(dp[m][n])
}