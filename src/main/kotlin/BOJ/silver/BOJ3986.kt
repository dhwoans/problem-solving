package BOJ.silver

import java.io.BufferedReader
import java.util.Stack

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val n = readLine().toInt()
    var count =0
    repeat(n){
        val stack = Stack<Char>()
        val word = readLine().map { it.toChar() }.toCharArray()
        for( ch in word){
            if(stack.isEmpty()){
                stack.add(ch)
            }else if((stack.peek()=='A'&&ch=='A')||(stack.peek()=='B'&&ch=='B')){
                stack.pop()
            }else{
                stack.add(ch)
            }
        }
        if(stack.isEmpty())count++
    }
    println(count)
}