package BOJ.silver

import java.io.BufferedReader

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val t = readLine().toInt()
    repeat(t){
        val (n,m)   =  readLine().split(" ").map{ it.toLong()}
        var small = if(n>m) m else n
        var big = if(n<=m) m else n
        while (small!=0L){
            var temp =  big % small
            big = small
            small = temp
        }
        val answer:Long = (n*m)/big
        println(answer)
    }
}