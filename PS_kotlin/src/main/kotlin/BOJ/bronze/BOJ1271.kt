package BOJ.bronze

fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toBigInteger)
    println(n/m)
    println(n%m)
}