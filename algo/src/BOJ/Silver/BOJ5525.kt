package BOJ.Silver

val sb = StringBuilder()
fun main() {
    val n = readln().toInt()
    sb.append("I").append("OI".repeat(n))
    val m = readln().toInt()
    val str = readln()
    var count = 0
    var turn = 0
    var k = 0

    while (turn < str.length - 2) {
        if (str.substring(turn, turn + 3) == "IOI") {
            k++
            turn+=2
            if(k==n){
                k--
                count++
            }
        }else{
            turn++
            k =0
        }
    }
    println(count)
}

