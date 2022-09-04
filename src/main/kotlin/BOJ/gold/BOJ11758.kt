package BOJ.gold

fun main() {
    val arr = ArrayList<Pair<Int,Int>>().apply{
        this.add(Pair(0,0))
    }

    repeat(3){
        val(x,y)= readLine()!!.split(" ").map(String::toInt)
        arr.add(Pair(x,y))
    }

    val answer = (arr[2].first-arr[1].first)*(arr[3].second-arr[1].second)-(arr[2].second-arr[1].second)*(arr[3].first-arr[1].first)
    if(answer<0) println(-1)
    else if(answer>0)println(1)
    else println(0)
}