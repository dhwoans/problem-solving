package BOJ.silver

import java.io.BufferedReader


fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()
    val map = HashMap<Long,Int>()
    repeat(n){
        val num = readLine().toLong()
        map.put(num,map.getOrDefault(num,0)+1)
    }
    val max = map.maxOf { it.value }
    val answer =map.filter { it.value >= max }.minOf { it.key }
    println(answer)
}