package BOJ.Gold

import java.lang.Long.max
import java.util.*
import kotlin.collections.ArrayList


fun main() {
    val (n,g,k) = readln().split(" ").map{it.toInt()}
    val arr = ArrayList<Triple<Int,Int,Int>>()
    repeat(n){
        val (s,l,o)= readln().split(" ").map{it.toInt()}
        arr.add(Triple(s,l,o))
    }
    var start = 0L
    var end = 2e9.toLong()
    var ans = 0L
    while(start<=end){
        val mid = (start+end)/2
        if(check(mid,g,k,arr)){
            ans = max(ans, mid)
            start = mid+1
        }else{
            end = mid-1
        }
    }
    println(ans)
}
private fun check(mid:Long,g:Int,k:Int,arr:ArrayList<Triple<Int,Int,Int>>):Boolean {
    var sum = 0L
    var que = PriorityQueue<Long>(reverseOrder())
    //세균수 카운트
    for(i in arr){
        if(i.third==0) sum += max(1L, (mid-i.second))*i.first
        else que.add(max(1L, (mid-i.second))*i.first)
    }
    //중요하지 않은 식재료 제거
    repeat(k){
        que.poll()
    }
    sum += que.sum()
    return sum <= g
}