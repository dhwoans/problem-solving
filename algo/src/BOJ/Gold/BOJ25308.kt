package BOJ.gold

import kotlin.math.sqrt

private lateinit var arr:IntArray
private lateinit var visited:BooleanArray
private lateinit var pick:IntArray
private var count =0

fun main() {
    //순열 구하기
    arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    visited = BooleanArray(arr.size)
    pick = IntArray(arr.size)
    Permutation(0)
    println(count)

}
private fun Permutation(cnt:Int){
    if(cnt==pick.size){
        //ccw
        ccw()
    }
    for(i in 0 until visited.size){
        if(visited[i])continue
        visited[i]=true
        pick[cnt]=arr[i]
        Permutation(cnt+1)
        visited[i]=false
    }
}

private fun ccw(){
    //좌표만들기
    val xy  = Array(8){Pair(0.0,0.0)}.apply{
        for(i in 0 .. pick.lastIndex) {
            when (i) {
                0 -> {
                    this[i] = Pair(0.0, pick[i].toDouble())
                }
                1 -> {
                    this[i] = Pair(pick[i]/sqrt(2.0), pick[i]/sqrt(2.0))
                }
                2 -> { // y==0
                    this[i] = Pair(pick[i].toDouble(), 0.0)
                }
                3 -> {
                    this[i] = Pair(pick[i]/sqrt(2.0), -pick[i]/sqrt(2.0))
                }
                4->{
                    this[i] = Pair(0.0, -pick[i].toDouble())
                }
                5 -> {
                    this[i] = Pair(-pick[i]/sqrt(2.0), -pick[i]/sqrt(2.0))
                }
                6 ->{
                    this[i] = Pair(-pick[i].toDouble(), 0.0)
                }
                7 -> {
                    this[i] = Pair(-pick[i]/sqrt(2.0), pick[i]/sqrt(2.0))
                }
            }
        }
    }
    //ccw 계산
    for(i in 0 .. xy.lastIndex){
        val a = xy[i]
        val b = if(i==xy.lastIndex)xy[0] else xy[i+1]
        val c = if(i>=xy.lastIndex-1) xy[i-6] else xy[i+2]
        val ccw = (b.first-a.first)*(c.second-a.second)-(c.first - a.first)*(b.second - a.second)
        if(ccw>0)return
    }
    count++

}