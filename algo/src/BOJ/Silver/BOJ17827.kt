package BOJ.silver

fun main() {
    val (n,m,k) = readLine()!!.split(" ").map(String::toInt)
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    val list = arr.copyOfRange(k-1,arr.size)
    val sb = StringBuilder()
    repeat(m){
        val num = readLine()!!.toInt()
        if(num<n) sb.appendLine(arr[num])
        else sb.appendLine(list[(num-n)%(n-(k-1))])
    }
    println(sb)

}