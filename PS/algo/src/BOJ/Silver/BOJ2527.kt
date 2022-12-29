package BOJ.Silver


private lateinit var arr:IntArray
fun main() {
    repeat(4){
        arr = readln().split(" ").map{it.toInt()}.toIntArray()
        val x1 = arr[0]
        val y1 = arr[1]
        val p1 = arr[2]
        val q1 = arr[3]
        val x2 = arr[4]
        val y2 = arr[5]
        val p2 = arr[6]
        val q2 = arr[7]
        if (p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
            println("d")
        } else if (x1 == p2 && y1 == q2 || x1 == p2 && q1 == y2 || p1 == x2 && q1 == y2 || p1 == x2 && y1 == q2) {
            println("c")
        } else if (p1 == x2 || q1 == y2 || p2 == x1 || y1 == q2) {
            println("b")
        } else {
            println("a")
        }
    }
}
