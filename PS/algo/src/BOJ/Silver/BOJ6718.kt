package BOJ.Silver

import java.lang.Math.pow
import kotlin.math.pow

fun main() {
    //소수체
    val isPrime = BooleanArray(2.0.pow(15.0).toInt()){true}
    isPrime[0]=false
    isPrime[1]=false

    for(i in 2 until isPrime.size){
        var j = 2
        while(i*j<isPrime.size){
            isPrime[i*j]=false
            j++
        }
    }

    while(true){
        val n = readln().toInt()
        if(n==0)return
        var count =0
        for(i in 2 .. n/2){
            if(isPrime[i]&&isPrime[n-i])count++
        }
        println(count)
    }
}