package BOJ.Silver

fun main() {
    val (n,m) =readln().split(" ").map{it.toInt()}
    for(i in 1.. m){
        println("0 ${i}")
    }
    var start =1
    for(i in m+1 until n){
        println("${start} ${i}")
        start=i
    }
}