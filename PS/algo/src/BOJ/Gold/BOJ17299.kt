package BOJ.Gold

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map{it.toInt()}.toIntArray()
    val ans = IntArray(arr.size){-1}
    val stack = Stack<Int>()
    val counter = IntArray(1_000_001)
    val sb = StringBuilder()
    arr.forEach {
        counter[it]++
    }
    for(i in arr.indices){
        if(stack.isEmpty()||counter[arr[stack.peek()]]>=counter[arr[i]]){
            stack.add(i)
        }else if(counter[arr[stack.peek()]]<counter[arr[i]]){
            while(stack.isNotEmpty()){
                if(counter[arr[stack.peek()]]<counter[arr[i]]){
                    ans[stack.peek()]=arr[i]
                    stack.pop()
                }else{
                    break
                }
            }
            stack.push(i)
        }
    }
    for(i in ans){
        sb.append(i).append(" ")
    }
    println(sb)
}