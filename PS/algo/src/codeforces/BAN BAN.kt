package codeforces

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        println(n / 2+n%2)
        var r = 1
        var e = 3 * n
        while (r < e) {
            println("${r} ${e}")
            r += 3
            e -= 3
        }
    }
}
