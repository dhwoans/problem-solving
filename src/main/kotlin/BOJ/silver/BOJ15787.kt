package BOJ.silver

import kotlin.math.pow

fun main() {
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    val arr = IntArray(n+1)
    //명령
    repeat(m){
        val command = readLine()!!.split(" ")
        when(command[0]){
            "1" ->{
                arr[command[1].toInt()] =  arr[command[1].toInt()] or (1 shl command[2].toInt())
            }
            "2" ->{
                arr[command[1].toInt()] =  arr[command[1].toInt()] and (1 shl command[2].toInt()).inv()
            }
            "3" ->{
                arr[command[1].toInt()] = arr[command[1].toInt()] shl 1
                arr[command[1].toInt()] = arr[command[1].toInt()] and ((1 shl 21)-1)
            }
            "4" ->{
                arr[command[1].toInt()] = arr[command[1].toInt()] shr 1
                arr[command[1].toInt()] = arr[command[1].toInt()] and 1.inv()
            }
        }
    }
    //검증
    var count = HashSet<Int>()
    for(i in 1 .. arr.lastIndex){
        count.add(arr[i])
    }
    println(count.size)
}