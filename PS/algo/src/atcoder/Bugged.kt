package atcoder

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val que = PriorityQueue<Int>()
    var ten = 0
    repeat(n){
        var temp = readLine()!!.toInt()
        if(temp%10==0)ten +=temp
        else que.add(temp)
    }
    var ans = que.sum()
    while(que.isNotEmpty()){
        if(ans%10==0) ans -= que.poll()
        else break
    }
    println(if(ans==0) 0 else ans+ten)
}