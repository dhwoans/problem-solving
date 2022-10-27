package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    var arr = readLine().map { (it-'0').toInt() }.toIntArray()
    if(!arr.contains(0)){
        println(-1)
    }else if(arr.sum()%3!=0){
        println(-1)
    }else{
        println(arr.map { it.toString() }.sortedDescending().joinToString(""))

    }
}