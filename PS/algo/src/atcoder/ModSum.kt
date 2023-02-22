package atcoder

fun main() {
    val n = readLine()!!.toInt()
    var sum =0L
    for(i in 1 until n){
        sum += i
    }
    println(sum)
}