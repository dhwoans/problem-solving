import java.util.*

fun main()= with(System.`in`.bufferedReader()) {
    var count =0
    val turn =readLine().toInt()
    val nums = StringTokenizer(readLine())
    repeat(turn){
         var num  = nums.nextToken().toInt()
        if(check(num)){
            count++
        }
    }
    print(count)
}

private fun check(num:Int):Boolean {
    if(num==1)return false
    for (i in 2 until num){
        if(num%i==0){
            return false
        }
    }
    return true
}