package BOJ.silver

fun main() {
    var (n,a,b) = readLine()!!.split(" ").map{it.toInt()}
    var count =1

    while(true){
        a = if(a%2!=0)(a+1)/2 else a/2
        b = if(b%2!=0)(b+1)/2 else b/2
        if(a==b)break
        count++
    }
    println(count)
}