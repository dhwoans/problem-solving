package BOJ

import java.io.BufferedReader

lateinit var arr:CharArray
lateinit var visited:BooleanArray
lateinit var str:String

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    arr = readLine().toCharArray()
    visited  = BooleanArray(arr.size)
    str = ""

    find(0,arr.size)
}

fun find(from:Int,to:Int){
    var index =-1
    var ch = 'Z'+1
    for(i in from until to){
        if(!visited[i]&&ch>arr[i]){
            ch=arr[i]
            index = i
        }
    }
    if(index!=-1){
        visited[index]=true
        visited.mapIndexed { index, b -> if(b) print(arr[index]) }
        println()

        find(index,to)
        find(from,index)
    }
}