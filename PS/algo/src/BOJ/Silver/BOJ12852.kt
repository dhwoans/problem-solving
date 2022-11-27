package BOJ.silver

import java.util.Stack

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val dp = IntArray(n+1){Int.MAX_VALUE}
    val arr = IntArray(n+1)
    dp[n]=0
    for(i in n downTo 0){
        if(i!=n&&dp[i]>dp[i+1]+1){
            dp[i]=dp[i+1]+1
            arr[i]=i+1
        }

        if(i%3==0&&dp[i/3]>dp[i]+1) {
            dp[i/3]=dp[i]+1
            arr[i/3]=i
        }
        if(i%2==0&&dp[i/2]>dp[i]+1) {
            dp[i/2]=dp[i]+1
            arr[i/2]=i
        }
    }
    println(dp[1])

    var num = 1
    val stack = Stack<Int>()
    while(num<n){
        stack.add(num)
        num=arr[num]
    }
    stack.add(n)
    while(stack.isNotEmpty()){
        print("${stack.pop()} ")
    }
}