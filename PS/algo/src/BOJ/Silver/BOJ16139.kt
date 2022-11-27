package BOJ.Silver

import java.util.*


fun main() {
    val sb = StringBuilder()
    val str = readln()
    val arr = Array(26) { IntArray(str.length) }
    for (i in str.indices) {
        arr[str[i] - 'a'][i]++
    }
    for (i in 1 until str.length) {
        for (j in 0..25) {
            arr[j][i] = arr[j][i - 1] + arr[j][i]
        }
    }
    repeat(readln().toInt()) {
        val st = StringTokenizer(readln())
        val c = st.nextToken().first()
        val from = st.nextToken().toInt()
        val to = st.nextToken().toInt()
        sb.appendLine(if (from == 0) arr[c - 'a'][to] else arr[c - 'a'][to] - arr[c - 'a'][from - 1])
    }
    println(sb)
}