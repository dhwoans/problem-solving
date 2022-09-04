package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())) {
    val n  = readLine().toInt()
    val answer = check(n)
    println(answer)
}

tailrec fun check(n:Int ,count:Int=0): Int {
    return if(n==0){
        count
    } else if(n<0){
        -1
    } else {
        if(n%5==0) check(n-5,count+1)
        else check(n-2,count+1)
    }
}