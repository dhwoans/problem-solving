package BOJ.silver


fun main() {
    val (n,m) = readLine()!!.split(" ")
    var count = 0
    if(n.length==m.length){
        for(i in 0 until n.length){
            if(n[i]==m[i]&&n[i]=='8')count++
            else if(n[i]!=m[i])break
        }
    }
    println(count)
}