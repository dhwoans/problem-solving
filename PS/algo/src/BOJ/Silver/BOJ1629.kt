package BOJ.silver

fun main() {
    val br = System.`in`.bufferedReader()
    val (a, b, c) = br.readLine().split(" ").map { it.toLong() }
    println(find(a, b, c,).mod(c))
}

private fun find(a:Long,b:Long,c:Long):Long{
    if(b==1L) return a % c

    val temp = find(a,b/2,c)

    return if(b % 2 ==0L) (temp * temp ).mod(c) else ((temp * temp ).mod(c) * a).mod(c)
}
