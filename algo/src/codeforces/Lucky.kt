package codeforces


fun main() {
    repeat(readLine()!!.toInt()) {
        val str = readLine()!!.toCharArray().map{it-'0'}.toIntArray()
        println(if ((str[0] + str[1] + str[2]) == str[3] + str[4] + str[5]) "YES" else "NO")
    }
}
