package codeforces

fun main() {
    val n = readLine()!!.toInt()
    val sum = IntArray(3)

    repeat(n){
            val (x,y,z)=readLine()!!.split(" ").map(String::toInt)
            sum[0]+=x
            sum[1]+=y
            sum[2]+=z
    }
    val answer = if(sum[0]==0&&sum[1]==0&&sum[2]==0) "YES" else "NO"
    println(answer)
}