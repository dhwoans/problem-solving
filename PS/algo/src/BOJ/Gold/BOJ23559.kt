package BOJ.Gold

import java.util.*

fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    var sum =0
    var money = m-1000*n
    var que = PriorityQueue<Int>(compareBy { -it })

    repeat(n){
        val (five,one) = readln().split(" ").map{it.toInt()}
        sum += one
        que.add(five-one)
    }
    while(money-4000 >= 0 && que.isNotEmpty()){
        if(que.peek()<0){
            que.poll()
        }else{
            money -= 4000
            sum += que.poll()
        }
    }
    println(sum)
}