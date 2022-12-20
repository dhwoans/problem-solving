package BOJ.Gold

import kotlin.math.abs

fun main() {
    val(x1,y1)=readln().split(" ").map{it.toInt()}
    val(x2,y2)=readln().split(" ").map{it.toInt()}
    val(x3,y3)=readln().split(" ").map{it.toInt()}
    println(String.format("%.1f",abs((x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2))).toDouble()/2))
    var count =0
    repeat(readln().toInt()){
        val(x4,y4) =readln().split(" ").map{it.toInt()}
        if(check(x1,y1,x2,y2,x4,y4)>=0&&check(x2,y2,x3,y3,x4,y4)>=0&&check(x3,y3,x1,y1,x4,y4)>=0){
           count++
        }else if(check(x1,y1,x2,y2,x4,y4)<=0&&check(x2,y2,x3,y3,x4,y4)<=0&&check(x3,y3,x1,y1,x4,y4)<=0){
            count++
        }

    }
    println(count)
}
private fun check(x1:Int,y1:Int,x2:Int,y2:Int,x3:Int,y3:Int):Int{
    return x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2)
}