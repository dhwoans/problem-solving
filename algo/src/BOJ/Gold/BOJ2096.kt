package BOJ

import kotlin.math.max
import kotlin.math.min

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val maxDP = IntArray(3)
    val minDP = IntArray(3)

    repeat(n) {
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        if (it == 0) {

                maxDP[0] = arr[0]
                maxDP[1] = arr[1]
                maxDP[2] = arr[2]
                minDP[0] = arr[0]
                minDP[1] = arr[1]
                minDP[2] = arr[2]


        } else {
            val maxPos0 = maxDP[0]
            val maxPos2 = maxDP[2]
            val minPos0 = minDP[0]
            val minPos2 = minDP[2]

            maxDP[0] = max(maxDP[0], maxDP[1]) + arr[0]
            minDP[0] = min(minDP[0], minDP[1]) + arr[0]


            maxDP[2] = max(maxDP[2], maxDP[1]) + arr[2]
            minDP[2] = min(minDP[2], minDP[1]) + arr[2]


            maxDP[1] = max(maxPos0, max(maxDP[1], maxPos2)) + arr[1]
            minDP[1] = min(minPos0, min(minDP[1], minPos2)) + arr[1]


        }
    }

    val max = max(maxDP[2],max(maxDP[0],maxDP[1]))
    val min = min(minDP[2],min(minDP[0],minDP[1]))

    println("$max $min")
}