package BOJ.gold

fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
    val num = arr.minOrNull()!!
    var answer =0
    for(i in 1 .. num){
        val value = arr[0]%i
        var flag = true
        for(j in 1 until n){
            if(value != arr[j]%i){
                flag = false
            }
        }
        if(flag)answer =i
    }
    println(answer)
}