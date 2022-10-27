package codeforces

import kotlin.math.max
import kotlin.math.min

fun main() {
    val sb = StringBuilder()
    repeat(readLine()!!.toInt()){
        val ren = IntArray(1001)
        val n = readLine()!!.toInt()
        var answer =-1
        readLine()!!.split(" ").map(String::toInt).forEachIndexed { index, i ->
            ren[i]=index+1
        }

        for(i in 1 ..1000){
            for(j in 1 .. 1000){
                if(ren[i]!=0 && ren[j]!=0 && gcd(i,j)==1)answer = max(answer,ren[i]+ren[j])
            }
        }

        sb.appendLine(answer)
    }
    println(sb)
}

private fun gcd(x: Int, y: Int) :Int{
    if(y==0){
        return x
    }else{
        return gcd(y,x%y)
    }
}
