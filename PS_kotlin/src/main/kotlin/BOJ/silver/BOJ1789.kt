package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toLong()
    var sum:Long =0
    var count =0
    var num =1
    while(true){
        if(sum>n)break
        sum+= num++
        count++
    }
    println(count-1)
}