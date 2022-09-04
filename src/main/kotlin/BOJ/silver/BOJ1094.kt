package BOJ.silver

fun main() {
    var count =0
    val n = readLine()!!.toInt().toString(2).forEach{
        if(it=='1')count++
    }
    println(count)
}