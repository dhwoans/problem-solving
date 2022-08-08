package BOJ.platinum

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n){IntArray(2)}
    val token = StringTokenizer(readLine())
    repeat(n){

        arr[it][0] = token.nextToken().toInt()
    }
    val x = ArrayList<Int>().apply{ this.add(Int.MIN_VALUE)}

    arr.forEach{
        if(it[0]>x[x.lastIndex]){
            x.add(it[0])
            it[1] = x.lastIndex

        } else {
            val num = lowerbound(x,it[0])
            x[num] = it[0]
            it[1] = num
        }
    }
    println(x.lastIndex)
    var count =x.lastIndex
    val stack = Stack<Int>()
    for(i in arr.lastIndex downTo 0){
        if(arr[i][1]==count){
            stack.add(arr[i][0])
            count--
        }
    }
    while(stack.isNotEmpty()){
        print("${stack.pop()} ")
    }
}
fun lowerbound(x:ArrayList<Int>,target:Int):Int{
    var start =0
    var end = x.lastIndex
    while(start<=end){
        val mid = (start + end) / 2
        if(x[mid]==target) return mid
        else if(x[mid]<target)start = mid + 1
        else end = mid - 1
    }
    return start
}