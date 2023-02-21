package atcoder

fun main() {
    val arr = charArrayOf(' ')+readLine()!!.toCharArray()
    var end = arr.size
    for(i in end-3 downTo 1 step 2){
        if(arr[i]==arr[i/2]){
            if(check(i,arr)){
                println(i)
                return
            }
        }
    }
}
fun check(end:Int,arr:CharArray):Boolean{
    val mid = end/2
    for(i in 1 .. mid){
        if(arr[i]!=arr[i+mid]){
            return false
        }
    }
    return true
}