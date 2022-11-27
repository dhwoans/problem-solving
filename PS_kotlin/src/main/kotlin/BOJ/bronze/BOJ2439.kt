package BOJ.bronze

fun main() {
    val n = readLine()!!.toInt()
    repeat(n){
        for(i in 1 .. n){
            if(i>=n-it) print("*")
            else print(" ")
        }
        println()
    }
}