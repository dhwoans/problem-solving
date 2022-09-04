import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    var num1 = readLine()!!.toInt()
    var count =0
    var que = PriorityQueue<Int>(reverseOrder())
    repeat(n-1){
        que.add(readLine()!!.toInt())
    }
    while(true){
        if(que.isEmpty()||que.peek()<num1)break
        count++
        que.add(que.poll()-1)
        num1++
    }
    println(count)
}