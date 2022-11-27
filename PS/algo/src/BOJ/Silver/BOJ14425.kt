package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val(n,m) = readLine().split(" ").map { it.toInt() }
    val map = HashMap<String,Int>()
    var count =0
    repeat(n){
        map.put(readLine(),0)
    }
    repeat(m){
        if(map.containsKey(readLine()))count++
    }
    println(count)
}