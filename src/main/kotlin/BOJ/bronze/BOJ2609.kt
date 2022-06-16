
fun main()= with(System.`in`.buffered()){
    var (num1,num2) = readLine()!!.split(" ").map { it.toInt() }

    println(gcd(num1, num2))
    println(num1*num2/ gcd(num1, num2))
}

private fun gcd(num1: Int, num2: Int):Int = if(num2==0)num1 else gcd(num2,num1%num2)

