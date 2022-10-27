package BOJ

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val answer = readLine().split("-").map { it->it[0] }.forEach(System.out::print)
}
