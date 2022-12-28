package BOJ.Gold

import kotlin.math.ceil
import kotlin.math.log2


fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map { it.toInt() }.toIntArray()
    val len = (ceil(log2(500_000.0))).toInt()
    val sparseTable = Array(len+1) { IntArray(n + 1) }
    for (i in 1 until sparseTable[0].size) {
        sparseTable[0][i] = arr[i-1]
    }
    for (i in 1 until sparseTable.size) {
        for (j in 1 until sparseTable[i].size) {
            sparseTable[i][j] = sparseTable[i - 1][sparseTable[i - 1][j]]
        }
    }
    //query
    val sb= StringBuilder()
    repeat(readln().toInt()) {
        var (m, x) = readln().split(" ").map { it.toInt() }

        for(i in sparseTable.indices){
            if(m and (1 shl i) > 0){
                x = sparseTable[i][x]
            }
        }
        sb.appendLine(x)
    }
    println(sb)
}