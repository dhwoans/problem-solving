package BOJ.bronze

import java.io.BufferedReader

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val (a,b,c) = readLine().split(" ").map { it.toInt() }
    if(a+b == c) println("$a+$b=$c")
    else if(a-b==c) println("$a-$b=$c")
    else if(a/b==c) println("$a/$b=$c")
    else if(a*b==c) println("$a*$b=$c")
    else if(a==b+c) println("$a=$b+$c")
    else if(a==b-c) println("$a=$b-$c")
    else if(a==b/c) println("$a=$b/$c")
    else if(a==b*c) println("$a=$b*$c")
}