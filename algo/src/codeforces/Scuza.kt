package codeforces

import kotlin.math.max

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val sb = StringBuilder()
        val (n, q) = readLine()!!.split(" ").map(String::toInt)
        val temp = readLine()!!.split(" ").map(String::toInt).toIntArray()
        val acc = LongArray(n)
        val max = IntArray(n)
        var sum = 0L
        var mx = 0

        repeat(n) {
            sum += (temp[it]).toLong()
            mx = max(temp[it],mx)
            acc[it] = sum
            max[it] = mx
        }
        val question = readLine()!!.split(" ").map(String::toInt).toIntArray()
        repeat(q) {
            val result= upperBound(question[it],max)-1
            if(result<0) sb.append(0).append(" ")
            else sb.append(acc[result]).append(" ")
        }
        println(sb)
    }
}
fun upperBound(target:Int,max:IntArray):Int{
    var start = 0
    var end = max.size
    while(start<end){
        val mid = (start+end)/2

        if(max[mid]<=target){
            start = mid+1
        }else{
            end = mid
        }
    }
    return end
}