package BOJ.Silver


fun main() {
    val (r, c, k) = readln().split(" ").map(String::toInt)
    val arr = Array(r) { IntArray(c) }.apply {
        for (i in 0 until r) {
            this[i] = readln().split(" ").map(String::toInt).toIntArray()
        }
    }
    var min = Int.MAX_VALUE
    var answer =0
    for (len in 256 downTo 0) {
        var count = 0
        var flag = true
        var inven = k
        out@ for (i in 0 until r) {
            for (j in 0 until c) {
                if (len > arr[i][j]) {
                    inven -= len - arr[i][j]
                    count += len-arr[i][j]
                } else if(len < arr[i][j]) {
                    inven += arr[i][j] - len
                    count += (arr[i][j] - len) * 2
                }
            }
        }
        if(inven<0)continue
        if (count<min) {
            min = count
            answer = len
        }
    }
    println("${min} ${answer}")
}