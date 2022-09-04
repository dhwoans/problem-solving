package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val t  = br.readLine().toInt()
    repeat(t){
        val (h,w,n) = br.readLine().split(" ").map { it.toInt() }
        val layer = if(n%h==0)h else n%h
        val room = if(n%h==0) (n/h) else (n/h)+1
        println("${layer}${if(room>=10)room else "0$room"}")
    }
}