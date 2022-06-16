import java.io.BufferedReader
import java.io.InputStreamReader


fun main()=with(BufferedReader(InputStreamReader(System.`in`))){
    repeat(readLine()!!.toInt()){
        var (num1 , num2)=readLine().split(" ").map { it.toInt() }
        println(num1*num2/gcd(num1, num2))

    }
}

private fun gcd(num1: Int, num2: Int):Int {
    if(num2==0)return num1
    else return gcd(num2 , num1 % num2)
}
