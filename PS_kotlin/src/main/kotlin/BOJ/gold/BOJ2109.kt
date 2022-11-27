package BOJ.gold

import java.util.*

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val que =PriorityQueue<Lecture>()
    val arr = IntArray(10001)
    //정렬
    repeat(n){
        val(cost , day) = br.readLine().split(" ").map{it.toInt()}
        que.add(Lecture(cost,day))
    }
    while(que.isNotEmpty()){
        val temp = que.poll()
        if(arr[temp.day]!=0){
            val min = PriorityQueue{a:IntArray,b:IntArray -> a[0]-b[0]}
            for(i in 1 until temp.day){
                if(temp.cost>arr[i]){
                    if(min.isEmpty() || min.peek()[0]>arr[i]) min.add(intArrayOf(arr[i],i))
                }
            }
            if(min.isNotEmpty()) arr[min.poll()[1]] = temp.cost


        }else arr[temp.day]=temp.cost

    }
    println(arr.sum())

}
private data class Lecture(val cost:Int,val day:Int):Comparable<Lecture>{
    override fun compareTo(other: Lecture): Int {
        return if(this.day == other.day) other.cost- this.cost
        else this.day - other.day
    }

}