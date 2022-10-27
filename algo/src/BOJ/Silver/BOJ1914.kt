package BOJ.silver

import java.io.BufferedReader
import java.math.BigInteger

fun main()=with(BufferedReader(System.`in`.bufferedReader())) {
    val n = readLine()!!.toInt()
    val sb = StringBuffer();
    var cnt =0

    fun hanoi(n:Int,from:Int,via:Int,to:Int) {
        if (n == 0) return

        cnt += 1
        hanoi(n-1,from,to,via)
        sb.append("$from $to").append("\n")
        hanoi(n-1,via,from,to)
    }

    if(n<=20){
        hanoi(n,1,2,3)
        println("$cnt \n$sb")
    }else println((BigInteger("2").pow(n).subtract(BigInteger("1"))))
}