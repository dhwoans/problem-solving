package BOJ.silver

import java.util.*

fun main() {
    var count =1

    while(true){
        val str = readLine()!!
        if(str.contains("-"))break
        val answer =checkStr(str)
        println("${count++}. ${answer}")
    }
}

private fun checkStr(str: String):Int {
    val stack = Stack<Char>()
    var flag = true;
    for(i in str){
        if(stack.isEmpty()){
            if(i=='}')flag = false;
            stack.add(i);
        }else if(i=='}'&&stack.peek()=='{'){
            stack.pop()
        }else {
            stack.add(i)
        }
    }
    var count =0
    if(stack.size!=0){
        while(stack.isNotEmpty()){
            var temp:String = ""
            temp +=stack.pop()
            temp +=stack.pop()
            if(temp=="{{"||temp=="}}")count++;
            else count+=2

        }
    }
    return count
}