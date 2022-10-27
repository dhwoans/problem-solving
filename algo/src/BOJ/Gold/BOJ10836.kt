package BOJ.gold



fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    val map = IntArray(n + (n - 1)) { 1 }
    //입력
    repeat(m) {
        val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
        var num = 0
        for ((v, i) in arr.withIndex()) {
            for (j in 0 until i) {
                map[num++] += v
            }
        }

    }
    //출력
    val sb = StringBuilder()
    for (i in 0 until n) {
        for (j in 0 until n) {
            if (j == 0) {
                sb.append("${map[n - 1 - i]} ")
            } else {
                sb.append("${map[n - 1 + j]} ")
            }

        }
        sb.appendLine()
    }
    println(sb)
}