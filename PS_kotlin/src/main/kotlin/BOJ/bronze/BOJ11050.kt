package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,k) = br.readLine().split(" ").map { it.toInt() }
    if(k==0){
        println(1)
    }else{
        val num1=(n-k+1 .. n).reduce{total,it -> total*it}
        val num2=(1..k).reduce{total,it -> total*it}
        println(num1/num2)
    }
}