package codeforces

private lateinit var arr:IntArray

fun main() {
    val n = readLine()!!.toInt()
    arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    arr.sort()
    val m = readLine()!!.toInt()
    repeat(m){
        val coin = readLine()!!.toInt()
        println(upper(coin))
    }
}

private fun upper(coin:Int):Int{
    var start = 0
    var end = arr.size
    while(start<end){
        val mid = (start + end)/2

        if(arr[mid]<=coin)start = mid+1
        else end = mid
    }
    return start
}