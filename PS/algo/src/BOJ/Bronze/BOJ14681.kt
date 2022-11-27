package BOJ.bronze

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val x = readLine().toInt()
    val y = readLine().toInt()

    when{
        (x>0 && y>0) -> println(1)
        (x<0 && y>0) -> println(2)
        (x<0 && y<0) -> println(3)
        (x>0 && y<0) -> println(4)
    }
}