package BOJ.silver

import java.io.BufferedReader
import java.util.Stack

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()
    val stack = Stack<Int>()
    var pointer =1
    val sb = StringBuilder()
    repeat(n){
        val num = readLine().toInt()
        if(stack.isEmpty()||stack.peek()<num){
            while(pointer<=num){
                stack.add(pointer++)
                sb.append("+").append("\n")
            }
            if(stack.isEmpty()){
                println("NO")
                return@with
            }
            stack.pop()
            sb.append("-").append("\n")
        }else {

            while(!stack.isEmpty()&&stack.peek()>=num){
                stack.pop()
                sb.append("-").append("\n")
            }
        }
    }
    if(stack.isEmpty()) println(sb)
    else println("NO")
}