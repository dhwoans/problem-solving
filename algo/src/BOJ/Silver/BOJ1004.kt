package BOJ

import kotlin.math.*


fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        var count = 0
        val (x1, y1, x2, y2) = readLine()!!.split(" ").map(String::toInt)
        val n = readLine()!!.toInt()
        repeat(n) {
            val (c1, c2, r) = readLine()!!.split(" ").map(String::toInt)
            if ((c1 - x1).toDouble().pow(2) + (c2 - y1).toDouble().pow(2) < r.toDouble().pow(2) &&
                (c1 - x2).toDouble().pow(2) + (c2 - y2).toDouble().pow(2) > r.toDouble().pow(2)
            ) count++
            else if ((c1 - x2).toDouble().pow(2) + (c2 - y2).toDouble().pow(2) < r.toDouble().pow(2) &&
                (c1 - x1).toDouble().pow(2) + (c2 - y1).toDouble().pow(2) > r.toDouble().pow(2)
            ) count++
        }
        println(count)
    }
}