package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    println(if(n%2==0)"SK" else "CY" )
}