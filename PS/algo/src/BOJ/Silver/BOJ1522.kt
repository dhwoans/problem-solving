package BOJ.Silver

import kotlin.math.min

fun main() {
    val arr =readln()

    val counta  = arr.count{it=='a'}
    val countb  = arr.count{it=='b'}
    var ans =slide(arr,counta,'a')
    ans = min(ans,slide(arr,countb,'b'))
    println(ans)

}
private fun slide(arr:String,len:Int,target:Char):Int{
    var count =0
    for(i in 0 until len){
        if(arr[i]!=target)count++
    }
    var ans = count
    var start =0
    var end = len-1
    while(end<arr.length-1){
        if(arr[start++]!=target)count--
        if(arr[++end]!=target)count++
        ans = min(ans,count)
    }
    return ans
}