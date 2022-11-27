package codeforces

fun main() {
    val (n,m,a,b) = readLine()!!.split(" ").map(String::toInt)
    val cost = n*a
    val special = (n/m)*b
    val plus = if((n%m)*a>b) b else (n%m)*a

    println(if(cost>special+plus)special+plus else cost)
}