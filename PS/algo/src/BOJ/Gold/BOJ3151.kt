package BOJ.Gold

import kotlin.math.abs

fun main() {
    val n =readln().toInt()
    val arr = readln().split(" ").map{it.toInt()}.toIntArray()
    var count = 3_000_000_000
    var ans = Triple<Int,Int,Int>(0,0,0)
    arr.sort()
    for(i in 0 until arr.size-1){
        var start = i+1
        var end = arr.size-1

        while(start<end){
            val v:Long= arr[start].toLong() + arr[end] + arr[i]
            if(abs(v)<count){
                count =abs(v)
                ans = Triple(arr[i],arr[start],arr[end])
            }
            if(v<=0){
                start++
            }else{
               end--
            }
        }
    }

    println("${ans.first} ${ans.second} ${ans.third}")
}