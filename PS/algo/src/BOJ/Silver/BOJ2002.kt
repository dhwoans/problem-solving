package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val map = HashMap<String, Int>()
    val arr = IntArray(n)
    repeat(n){
        map[readln()] = it+1
    }
    repeat(n){
        arr[it]=map[readln()]!!
    }
    var num =1
    var count =0
    val set = HashSet<Int>()
    for(i in 0 until arr.size){
        if(arr[i]==num) {
            num++
            while (set.contains(num)) {
                num++
            }
        }else if(num<arr[i]){
            count++
            set.add(arr[i])
        }
    }
    println(count)
}