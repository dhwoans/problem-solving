package BOJ.Gold

fun main() {
    while(true){
        val str = readLine()?: break
        val len = str.toInt() * 10_000_000
        val n = readln().toInt()
        val arr = IntArray(n)
        repeat(n) {
            arr[it] = readln().toInt()
        }
        arr.sort()
        var start = 0
        var end = n - 1
        var flag = false
        while (start < end) {
            if (arr[start] + arr[end] == len) {
                flag = true
                break;
            } else if (arr[start] + arr[end] > len) {
                end--
            } else if (arr[start] + arr[end] < len) {
                start++
            }
        }
        if(flag) println("yes ${arr[start]} ${arr[end]}")
        else println("danger")
    }
}