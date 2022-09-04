package BOJ.gold

fun main() {
    val (x1,y1,x2,y2) = readLine()!!.split(" ").map(String::toLong)
    val (x3,y3,x4,y4) = readLine()!!.split(" ").map(String::toLong)
    val a = if((x2-x1)*(y3-y1)-(x3-x1)*(y2-y1)<0) -1 else 1
    val b = if((x2-x1)*(y4-y1)-(x4-x1)*(y2-y1)<0) -1 else 1
    val c = if((x4-x3)*(y1-y3)-(x1-x3)*(y4-y3)<0) -1 else 1
    val d = if((x4-x3)*(y2-y3)-(x2-x3)*(y4-y3)<0) -1 else 1

    if(a!=b && c!=d) println(1)
    else println(0)
}