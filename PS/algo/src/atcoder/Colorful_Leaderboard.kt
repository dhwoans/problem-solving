import kotlin.math.min

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map{it.toInt()}.toIntArray()
    val rank = IntArray(9)
    for(i in arr) {
        if(i>3199) rank[8]++
        else rank[i/400]++
    }
    val ans = rank.take(8).count{it!=0}
    println("${if(ans==0)1 else ans} ${rank[8]+ans}")

}