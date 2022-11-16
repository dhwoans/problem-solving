package codeforces

import kotlin.math.abs

fun main() {
    val n = readln().toInt()
    val boy = readln().split(" ").map(String::toInt).toIntArray()
    val m = readln().toInt()
    val girl = readln().split(" ").map(String::toInt).toIntArray()
    boy.sort()
    girl.sort()

    var result = 0
    for (i in 0 until n) {
        for (j in 0 until m) {
            if (abs(boy[i] - girl[j]) <= 1) {
                girl[j] = 1000
                result++
                break
            }
        }
    }
    println(result)
}