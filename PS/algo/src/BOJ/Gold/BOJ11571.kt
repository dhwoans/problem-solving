package BOJ.Gold

fun main() {

    val sb = StringBuilder()
    repeat(readln().toInt()) {
        val (n,m) = readln().split(" ").map{it.toInt()}
        val arr = IntArray(100000){-1}
        var start = 0
        var end = 0
        var idx = 0
        var tmp = n
        while (true) {
            tmp = tmp % m * 10
            if (arr[tmp] != -1) {
                start = arr[tmp]
                end = idx
                break
            }
            arr[tmp] = idx++
        }
        sb.append(n / m).append(".")
        tmp = n % m * 10
        for (i in 0 until start) {
            sb.append(tmp / m)
            tmp = tmp % m * 10
        }
        sb.append("(")
        for (i in start until end) {
            sb.append(tmp / m)
            tmp = tmp % m * 10
        }
        sb.appendLine(")")
    }
    println(sb.toString())
}


