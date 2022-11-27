package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val n = readLine().toInt()
    val map = HashMap<String,Int>()
    repeat(n){
        val str = readLine()
        map.put(str,map.getOrDefault(str,0)+1)
    }
    val max= map.maxOf { it.value }
    val answer = map.filter { it.value ==max }.toSortedMap().firstKey()
    println(answer)
}