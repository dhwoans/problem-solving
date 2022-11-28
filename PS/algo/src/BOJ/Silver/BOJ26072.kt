package BOJ.Silver

private lateinit var x:IntArray
private lateinit var w:IntArray
private lateinit var a:ArrayList<Pair<Int,Int>>


fun main() {
    val (n,l) = readln().split(" ").map{it.toInt()}
    x=r()
    w=r()
    a=mix()
    a.sortWith(compareBy({it.first}))
    //이분탐색
    var start:Double = (a.first().first).toDouble()
    var end:Double = (a.last().first).toDouble()
    while(start+0.0000001<end){
        val mid:Double = (start+end) /2
        if(check(mid)) {
            start =mid
        }
        else end= mid
    }
    val str = "%.6f".format(start)
    println(str)
}

private fun mix() = ArrayList<Pair<Int,Int>>().apply{
    repeat(x.size) {
        this.add(Pair(x[it], w[it]))
    }
}


private fun r() = readln().split(" ").map(String::toInt).toIntArray()
private fun check(mid:Double):Boolean{
    var l =0.0
    var r =0.0
    for(i in a){
        if(i.first<=mid){
            l+=(mid-i.first)*i.second
        }
        if(i.first>=mid){
            r+=(i.first-mid)*i.second
        }
    }
    return l<=r
}