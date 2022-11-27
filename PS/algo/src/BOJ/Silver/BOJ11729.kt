package BOJ.silver

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val n  = readLine().toInt()
    val sb = StringBuilder()
    var count =0;
    fun hanoi(cnt:Int,from:Int,via:Int,to:Int) {
        if (cnt == 0) return
        else {
            count++
            hanoi(cnt - 1, from, to, via)
            sb.append(from).append(" ").append(to).append("\n")
            hanoi(cnt - 1, via, from, to)
        }
    }
    hanoi(n,1,2,3)
    println(count)
    println(sb)
}