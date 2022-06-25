package BOJ.bronze

import java.io.BufferedReader


fun main() = with(BufferedReader(System.`in`.bufferedReader())){
   val a = readLine().toInt()
   val b = readLine().toInt()
   val c = readLine().toInt()
    if(a+b+c!=180) println("Error")
    else{
        if(a==b&&b==c) println("Equilateral")
        else if(a==b||b==c||a==c) println("Isosceles")
        else println("Scalene")
    }

}