package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val str = br.readLine()
    val arr = ArrayList<ArrayList<Int>>()
    var count = 0

    arr.apply {
        (0..25).forEach { this.add(ArrayList()) }
    }
    str.forEachIndexed { index, c -> arr[c - 'A'].add(index) }

    for (i in 0 until arr.size) {
        for (j in 0 until arr.size) {
            if (arr[i][0] < arr[j][0] &&  arr[j][0]< arr[i][1] && arr[i][1] < arr[j][1]) count++
        }
    }
    println(count)
}