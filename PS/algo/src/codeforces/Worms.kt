package codeforces

fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toIntArray()
    val index = IntArray(1000_0001)

    var sum = 0
    repeat(n) {
        sum += arr[it]
        index[sum + 1]++
    }

    index[0] = 1
    for (i in 1..sum) {
        index[i] += index[i - 1]
    }
    val m = readln().toInt()
    val question = readln().split(" ").map(String::toInt).toIntArray()
    repeat(m) {
        sb.appendLine(index[question[it]])
    }
    println(sb)
}