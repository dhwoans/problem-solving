package BOJ.gold

import kotlin.math.max

fun main() {
    val br = System.`in`.bufferedReader()
    val str1 = br.readLine()
    val str2 = br.readLine()
    val arr = Array(str1.length+1){IntArray(str2.length+1)}

    //LCS
    for(i in 1 until arr.size){
        for(j in 1 until arr[i].size){
            if(str1[i-1]==str2[j-1])arr[i][j]=arr[i-1][j-1]+1
            else arr[i][j]=max(arr[i-1][j],arr[i][j-1])
        }
    }
    var count = arr.flatMap{it.toList()}.maxOrNull()
    if(count!=0){
        println(count)
        //역추적
        val sb = StringBuilder()
        for(i in arr.size-1 downTo 1){
            for(j in arr[i].size-1 downTo 1){
                if(str1[i-1]==str2[j-1]&&arr[i][j]==count){
                    sb.append(str1[i-1])
                    count--
                    break;
                }
            }
        }
        println(sb.reverse())
    }else println(0)
}