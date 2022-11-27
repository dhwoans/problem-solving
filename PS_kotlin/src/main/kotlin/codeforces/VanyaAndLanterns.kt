import java.util.*

fun main() {
    val (n,m)= readLine()!!.split(" ").map(String::toInt)
    val arr = intArrayOf(0)+readLine()!!.split(" ").map(String::toInt).toIntArray()+intArrayOf(m)
    arr.sort()
    val answer = PriorityQueue<Double>(reverseOrder())

    for(i in 0 until arr.lastIndex){
        val num = (arr[i+1]-arr[i]).toDouble()
        if(i==0||i==arr.lastIndex-1){
            answer.add(num)
        }else{
            answer.add(num/2)
        }
    }
    println(String.format("%.10f",answer.poll()))
}