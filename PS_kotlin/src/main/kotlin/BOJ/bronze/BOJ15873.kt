package BOJ.bronze

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
     val n = readLine().toString()
    if(n.length>2){
        var a =0
        var b =0
        if(n[1]!='0'){
            a = n.substring(0,1).toInt()
            b = n.substring(1).toInt()
        }else{
            a = n.substring(0,2).toInt()
            b = n.substring(2).toInt()

        }
        println(a+b)
    }else{
        println(n.map { it.code -('0').code }.sum())

    }
}