package BOJ.silver

fun main() {
    val n = readLine()!!.toInt()
    var count =0
    val num = readLine()!!.toString().forEach{
        if(it=='1') count++
    }
    println(count)

}