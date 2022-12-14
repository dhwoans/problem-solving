package BOJ.Gold

import kotlin.math.min

private lateinit var arr:IntArray
private val memo = Array(5){Array(5){IntArray(100_000)}}
fun main() {
    arr = readln().split(" ").map{it.toInt()}.toIntArray()
    val result =  dfs(0,0,0)
    println(result)
}

private fun dfs(r:Int,l:Int,n:Int):Int{
    if(arr.size-1==n){
        return 0
    }
    if(memo[r][l][n]!=0){
        return memo[r][l][n]
    }
    memo[r][l][n]=min(check(l,arr[n])+dfs(r,arr[n],n+1),check(r,arr[n])+dfs(arr[n],l,n+1))

    return memo[r][l][n]
}

private fun check(num:Int,target:Int):Int{
    if(num==target) return 1
    when(num){
        0 -> return 2
        1 -> return if(target==3) 4 else  3
        2 -> return if(target==4) 4 else  3
        3 -> return if(target==1) 4 else  3
        4 -> return if(target==2) 4 else  3
        else ->return  -987
    }
}