import kotlin.math.floor
import kotlin.math.pow
import kotlin.math.sqrt

fun main()=with(System.`in`.bufferedReader()){
    val(d,h,w) = readLine().split(" ").map { it.toDouble() }
    val x = d/sqrt(h.pow(2)+w.pow(2))
    println("${floor(h*x).toInt()} ${floor(w*x).toInt()}")
}