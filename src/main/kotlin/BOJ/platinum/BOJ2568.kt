package BOJ.platinum

import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: Array<IntArray>
private lateinit var x: ArrayList<Int>

fun main() {
    val n = readLine()!!.toInt()
    x = ArrayList<Int>().apply { this.add(0) }
    arr = Array(n) { IntArray(3) }.apply {
        repeat(n) {
            this[it] = readLine()!!.split(" ").map(String::toInt).toIntArray() + intArrayOf(0)
        }
    }
    arr.sortBy { it[0] }

    for (i in 0 until arr.size) {
        if (arr[i][1] > x[x.lastIndex]) {
            x.add(arr[i][1])
            arr[i][2] = x.lastIndex
        } else {
            val index = lowerbound(arr[i][1])
            x[index] = arr[i][1]
            arr[i][2] = index
        }
    }
    println(n - x.lastIndex)

    var count = x.lastIndex
    val check = BooleanArray(n)
    for(i in arr.lastIndex downTo 0){
        if(arr[i][2]==count){
            count--
            check[i]=true
        }
    }
    for(i in 0 .. arr.lastIndex){
        if(!check[i]){
            println(arr[i][0])
        }
    }
}

private fun lowerbound(target: Int): Int {
    var start = 0
    var end = x.lastIndex
    while (start <= end) {
        val mid = (start + end) / 2
        if (x[mid] == target) return mid
        else if (x[mid] < target) start = mid + 1
        else end = mid - 1
    }
    return start
}