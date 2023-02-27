package atcoder

fun main() {
    val (a,b,c) = readLine()!!.split(" ").map{it.toInt()}
    for(i in 2 .. 100){
        if((a*i)%b==c){
            println("YES")
            return
        }
    }
    println("NO")
}