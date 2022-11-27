package BOJ.bronze

fun main() {
    val (a,b,c)  = readLine()!!.split(" ").map(String::toInt)
    if(c%2==1){
        println(a xor b)
    }else{
        println(a)
    }
}