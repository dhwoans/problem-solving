package BOJ.silver

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val (n,m) = readLine().split(" ").map { it.toInt() }
    val Nmap = HashMap<Int,Int>()
    val Mmap = hashMapOf<Int,Int>()
    var Ncount =0
    var Mcount =0
    readLine().split(" ").forEach{
        Nmap.put(it.toInt(),0)
    }
    readLine().split(" ").forEach{
        Mmap.put(it.toInt(),0)
    }

    for(i in Nmap.keys){
        if(!Mmap.containsKey(i))Ncount++
    }
    for(i in Mmap.keys){
        if(!Nmap.containsKey(i))Mcount++
    }
    println(Ncount+Mcount)
}