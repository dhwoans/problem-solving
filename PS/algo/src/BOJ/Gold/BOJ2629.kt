package BOJ.Gold

import kotlin.math.abs

private val dp = Array(31){BooleanArray(15001)}
private val arr = IntArray(31)
fun main() {
    val n = readln().toInt()
    readln().split(" ").map{it.toInt()}.forEachIndexed { index, i ->
        arr[index]=i
    }

    check(0,0,arr,n)
    val m = readln().toInt()
    readln().split(" ").map{it.toInt()}.forEach{
        if(it>15000) print("N ")
        else if(dp[n][it]) print("Y ")
        else print("N ")
    }
}

private fun check(i:Int,w:Int,arr:IntArray,n:Int){
    if(i>n || dp[i][w]) return
    dp[i][w]=true
    check(i+1,w+arr[i],arr,n)
    check(i+1,abs(w-arr[i]),arr,n)
    check(i+1,w,arr,n)
}