package BOJ.bronze

fun main() {
    val arr = intArrayOf(1, 1, 2, 2, 2, 8)
    readLine()!!.split(" ").map(String::toInt).toIntArray().forEachIndexed { index, i ->
        print("${arr[index] - i} ")
    }
}