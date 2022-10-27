package BOJ.bronze

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    repeat(3){
        val arr = readLine().split(" ").map{it.toInt()}.toIntArray()
        val zero  = arr.count { it==0 }
        val one = arr.count {it==1}
        if(zero==1&&one==3) println("A")
        else if(zero==2&&one==2) println("B")
        else if(zero==3&&one==1) println("C")
        else if(zero==4) println("D")
        else println("E")
    }
}