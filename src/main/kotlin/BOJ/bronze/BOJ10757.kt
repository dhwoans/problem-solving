package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m) = br.readLine().split(" ").map{it.toBigDecimal()}
    println(n.plus(m))

}