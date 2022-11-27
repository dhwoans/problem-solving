package BOJ.bronze


fun main() {
    val (n,m) = readLine()!!.split(" ").map(String::toBigInteger)
    val answer = if(n-m<(0).toBigInteger()) -(n-m) else n-m
    println(answer)
}