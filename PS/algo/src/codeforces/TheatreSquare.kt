import kotlin.math.max

fun main() {
    val (n, m, k) = readLine()!!.split(" ").map(String::toLong)
    var x= n/k
    var y= m/k
    if(n%k!=0L)x++
    if(m%k!=0L)y++
    println(x*y)
}



