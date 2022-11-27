package BOJ.silver

import kotlin.math.*

fun main() {
    val n  = readLine()!!.toInt()
    var arr = ArrayList<XY>()
    repeat(n){
        val (x,y,c) = readLine()!!.split(" ").map(String::toInt)
        arr.add(XY(it+1,x.toDouble(),y.toDouble(),c))
    }
    arr.sort()
    arr.forEach{
        println(it.num)
    }
}

private data class XY (val num:Int ,val x:Double ,val y:Double ,val speed:Int ) :Comparable<XY>{
    val dis = (sqrt(x.pow(2) + y.pow(2)))/speed

    override fun compareTo(other: XY): Int {
        if(this.dis == other.dis) return this.num - this.num
        return  this.dis.compareTo(other.dis)
    }

}