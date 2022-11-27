package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList

private lateinit var x:ArrayList<Int>

fun main() {
    val n = readLine()!!.toInt()
    x = ArrayList<Int>().apply{this.add(Int.MIN_VALUE)}
    val switch = readLine()!!.split(" ").map(String::toInt).toIntArray()
    val bulb = readLine()!!.split(" ").map(String::toInt).toIntArray()


    val arr = Array(switch.size){IntArray(3)}.apply{
        repeat(n){
            this[it]=intArrayOf(switch[it],switch.indexOf(bulb[it]),0)
        }
    }


    arr.forEach{
        if(it[1]>x.last()){
            x.add(it[1])
            it[2] = x.lastIndex

        }
        else {
            val index = lowerBound(it[1])
            x[index] = it[1]
            it[2]= index

        }
    }

    println(x.lastIndex)
    var num = x.lastIndex
    val que = PriorityQueue<Int>()
    for(i in arr.lastIndex downTo 0 ){
        if(num==arr[i][2]){
            num--
            que.add(arr[arr[i][1]][0])
        }
    }

   while(que.isNotEmpty()){
       print("${que.poll()} ")

   }
}

private fun lowerBound(target:Int):Int{
    var start  = 0
    var end = x.lastIndex
    while(start<=end){
        val mid = (start + end)/2
        if(x[mid]<target) start = mid + 1
        else end = mid - 1
    }
    return start
}