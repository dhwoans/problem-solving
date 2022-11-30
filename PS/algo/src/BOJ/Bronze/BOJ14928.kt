package BOJ.Bronze

fun main() {
    val n = readln()
    var ans = 0
    for(i in n){
        ans=((ans*10)%20000303+((i-'0'))%20000303)%20000303
    }
    println(ans)
}