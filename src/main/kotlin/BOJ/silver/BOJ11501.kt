package BOJ.silver


fun main() {
    val br = System.`in`.bufferedReader()
    val t = br.readLine().toInt()
    val sb = StringBuilder()
    repeat(t){
        val n = br.readLine().toInt()
        var answer = 0L
        val arr = br.readLine().split(" ").map { it.toInt() }.toIntArray()
        var maxStock = 0
        for(i in arr.size-1 downTo 0){
            if(maxStock<arr[i]){
                maxStock=arr[i]
            }else{
                answer += (maxStock-arr[i])
            }
        }
        sb.append(answer).append("\n")
    }
    println(sb)
}