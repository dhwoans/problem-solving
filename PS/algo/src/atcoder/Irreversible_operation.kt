package atcoder

fun main() {
   val str = readLine()!!
    var count =0L
    var sum = 0L
    for(i in str.indices){
        if(str[i]=='W'){
            sum += count
        }else{
            count++
        }
    }
    println(sum)
}