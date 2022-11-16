package codeforces

import kotlin.math.max

fun main() {
    val (n,t)= readln().split(" ").map(String::toInt)
    val arr = readln().split(" ").map(String::toInt).toIntArray()

    var start =0
    var end = 0
    var sum = 0
    var ans = 0
    while(end<n){
        sum +=arr[end]
        if(sum>t){
            sum-=arr[start]
            start++
        }
        if(sum<=t){
            ans = max(ans,end-start+1)
        }
        end++
    }
    println(ans)
}