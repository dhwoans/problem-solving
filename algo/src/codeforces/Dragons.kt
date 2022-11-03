package codeforces

fun main() {
    var (s,n) = readLine()!!.split(" ").map(String::toInt)

    Array(n){IntArray(2)}.apply{
        repeat(n){
            this[it]= readLine()!!.split(" ").map(String::toInt).toIntArray()
        }
    }.sortedWith(compareBy({it[0]},{-it[1]})).forEach {  ints ->
        if(s<=ints[0]){
            println("NO")
            return
        }else{
            s+=ints[1]
        }
    }
    println("YES")
}