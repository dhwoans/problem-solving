
fun main() {
    val(n,m)= readln().split(" ").map{it.toInt()}
    val num = gcd(n,m)
    for(i in 1 .. num){
        if(num%i==0){
            println("${i} ${n/i} ${m/i}")
        }
    }
}
private fun gcd(a:Int,b:Int):Int = if(b==0) a else gcd(b,a%b)
