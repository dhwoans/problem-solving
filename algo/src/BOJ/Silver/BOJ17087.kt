package BOJ.Silver

import kotlin.math.max
import kotlin.math.min

fun main() {
    val (n, s) = readln().split(" ").map(String::toInt)
    val arr = readln().split(" ").map(String::toInt).toCollection(ArrayList<Int>())
    arr.add(s)
    arr.sort()
    val gap = ArrayList<Int>()
    for (i in 1 until arr.size) {
        gap.add(arr[i] - arr[i - 1])
    }
    if(gap.size==1){
        println(gap[0])
    }else{
        gap.sortDescending()
        var result = gcd(gap[0],gap[1])
        for(i in 2 until gap.size){
            result = gcd(max(result,gap[i]),min(result,gap[i]))
        }
        println(result)
    }
}
private fun gcd(a:Int,b:Int):Int{
    return if(b==0) a else gcd(b,a%b)

}