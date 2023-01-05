package BOJ.Gold

import java.util.*
import kotlin.math.min

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { IntArray(n) { 987654321 } }
    val ans = Array(n) { IntArray(n) { -1 } }
    for (i in arr.indices) {
        arr[i][i] = 0
    }
    //edge
    repeat(readln().toInt()) {
        val (a, b, c) = readln().split(" ").map { it.toInt() - 1 }
        arr[a][b] = min(arr[a][b], c + 1)
        ans[a][b] = a

    }
    //floyd
    for (k in arr.indices) {
        for (i in arr.indices) {
            for (j in arr.indices) {
                if (arr[i][j] > arr[i][k] + arr[k][j]) {
                    arr[i][j] = arr[i][k] + arr[k][j]
                    ans[i][j] = ans[k][j]
                }
            }
        }
    }
    //shortest-path
    for (i in arr) {
        for (j in i) {
            print("$j ")
        }
        println()
    }
    //추적
    for (i in ans.indices) {
        for (j in ans.indices) {
            if (arr[i][j] == -1) {
                println(0)
            } else {
                val sb = StringBuilder()
                val stack = Stack<Int>()
//                stack.add(j+1)
                find(i, j, ans, stack)

                while(stack.isNotEmpty()){
                    sb.append(stack.pop()).append(" ")
                }
                print("${sb.length/2} ")
                println(sb)

            }

        }
    }
}

private fun find(i: Int, j: Int, ans: Array<IntArray>, stack: Stack<Int>) {
    if (ans[i][j] == -1) {
        return
    }
    stack.add(ans[i][j] + 1)
    find(i, ans[i][j], ans, stack)
}