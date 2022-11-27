package BOJ.silver

fun main() {
    val (n, l) = readLine()!!.split(" ").map(String::toInt)
    var currentPos = 0
    var pre = 0
    repeat(n) {
        val (pos, red, green) = readLine()!!.split(" ").map(String::toInt)
        currentPos +=(pos-pre)
        pre = pos
        if(currentPos %(red+green)<red){
            currentPos+=(red-currentPos %(red+green))
        }
    }
    currentPos +=(l-pre)
    println(currentPos)
}