package BOJ.Gold

fun main() {
    repeat(readln().toInt()){
        val n = readln().toInt()
        val arr = readln().split(" ").map{it.toInt()}.toIntArray()
        arr.sort()
        var sum = arr[1]-arr[0]
        for(i in 2 until arr.size){
            sum = gcd(sum,arr[i]-arr[i-1])
        }
        if(sum==0){
            println("INFINITY")
        }else{
            println(sum)
        }

    }
}
private fun gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)