import kotlin.math.absoluteValue
import kotlin.math.pow

fun main()= with(System.`in`.bufferedReader()){
    val k = readLine().toDouble()
    val (d1,d2)= readLine().split(" ").map { it.toDouble() }
    val dis = (d1-d2).absoluteValue
    if(dis==0.0) println(k*k)
    else println(k.pow(2) - ((dis / 2).pow(2)))
}