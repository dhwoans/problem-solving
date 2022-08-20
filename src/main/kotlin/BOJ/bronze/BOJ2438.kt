package BOJ.bronze

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        repeat(it+1){print("*")}
        println()
    }
}