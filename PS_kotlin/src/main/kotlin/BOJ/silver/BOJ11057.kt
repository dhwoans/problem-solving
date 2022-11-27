package BOJ.silver

fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n) { IntArray(10) }.apply {
        this[0] = IntArray(10) { 1 }
    }
    for (i in 1 until arr.size) {
        arr[i][9]=1
        for(j in arr[i].lastIndex-1 downTo 0){
            arr[i][j]= arr[i][j+1]+arr[i-1][j] %10_007
        }
    }

    var answer =0
    for(i in 0..arr[n-1].lastIndex){
        answer +=arr[n-1][i] %10_007
    }
    println(answer %10_007)
}