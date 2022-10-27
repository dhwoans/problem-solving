
import java.io.BufferedReader
import java.io.InputStreamReader


fun main()= with(BufferedReader(InputStreamReader(System.`in`))){
    val num1 = readLine().toInt()
    val num2 = readLine().toString()
    val (a,b,c) = num2.map { it -> it-'0' }
    println(num1 *c)
    println(num1 *b)
    println(num1 *a)
    println(num1 *num2.toInt())
}