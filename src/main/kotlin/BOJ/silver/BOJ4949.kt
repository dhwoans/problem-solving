package BOJ.silver

import java.io.BufferedReader
import java.util.Stack

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    while (true) {
        val text = readLine()
        if (text == ".") {
            break
        }
        val stack = Stack<Char>()

        var isBalanced = true
        text.forEach {
            when (it){
                '(','[' ->{
                    stack.add(it)
                }
                ')' -> {
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop()
                    } else {
                        isBalanced = false
                        return@forEach
                    }
                }
                ']' ->{
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop()
                    } else {
                        isBalanced = false
                        return@forEach
                    }
                }
            }
        }
        if (stack.isNotEmpty()) {
            isBalanced = false
        }
        println(if(isBalanced)"yes" else "no")
    }
}