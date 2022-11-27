package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val word = readLine()
    var set = HashSet<String>()
    for (start in 0 .. word.length){
        for (end in 1+start .. word.length)
            set.add(word.substring(start,end))
    }
    println(set.size)
}