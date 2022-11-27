import kotlin.math.abs

fun main() {
    val n = readLine()!!.toInt()
    val arr = intArrayOf(0)+IntArray(n).apply{
        repeat(n){
            this[it]= readLine()!!.toInt()
        }
    }

    arr.sort()
    var count:Long=0
    arr.forEachIndexed{index,it->
        count+=abs(index-it)
    }
    println(count)
}

