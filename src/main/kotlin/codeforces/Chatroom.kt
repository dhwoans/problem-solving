package codeforces

fun main() {
    val arr = charArrayOf('h', 'e', 'l', 'l', 'o')
    var pointer = 0
    run() {
        readLine()!!.toString().forEach {
            if (it == arr[pointer]) {
                pointer++
            }
            if (pointer == arr.size) {
                println("YES")
                return
            }
        }
    }
    println("NO")

}