package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,r,c) = br.readLine().split(" ").map{it.toInt()}
    println(find(n,r,c))

}

fun find(n:Int,r:Int,c:Int):Int{
    return if(n==0) 0 else 2*(r%2)+(c%2) + 4*find(n-1,r/2,c/2)
}