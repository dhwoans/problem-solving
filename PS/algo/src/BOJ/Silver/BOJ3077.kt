package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").toTypedArray()
    val map = HashMap<String,Int>()
    readln().split(" ").forEachIndexed{ i,v->
        map[v] = i
    }
    var count=0
    for(i in 0 until arr.size){
        for(j in i+1 until arr.size){
            if(map[arr[i]]!!<map[arr[j]]!!)count++
        }
    }
    println("${count}/${n*(n-1)/2}")
}