package BOJ.Silver

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val n = readLine()!!.toInt()
    val arr =ArrayList<Queue<String>>()
    //앵무새 입력
    repeat(n){
        val que:Queue<String> = readLine()!!.split(" ").toCollection(LinkedList<String>())
        arr.add(que)
    }
    readLine()!!.split(" ").forEach { i ->
        var flag = true
        for(word in arr){
            if(i==word.peek()){
                flag =false
                word.poll()
            }
        }
        if(flag){
            println("Impossible")
            return
        }
    }

    arr.forEach {
        if(it.isNotEmpty()){
            println("Impossible")
            return
        }
    }
    println("Possible")
}