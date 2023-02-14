package BOJ.Gold

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n).apply{
        repeat(n){
            this[it]=readln().toInt()
        }
    }
    arr.sort()
    // arr[i]-arr[i-1]
    //gcd
    var ans = arr[1]-arr[0]
    for(i in 2 until n){
        ans =  gcd(ans,arr[i]-arr[i-1])
    }
    //div
    println(div(ans))

}
private fun gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)
private fun div(a:Int):StringBuilder{
    val sb = StringBuilder()
    for(i in 2 .. a){
        if(a%i==0){
            sb.append(i).append(" ")
        }
    }
    return sb
}