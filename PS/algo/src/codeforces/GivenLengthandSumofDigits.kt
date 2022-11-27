package codeforces

fun main() {
    val (n,m) =readln().split(" ").map(String::toInt)
    var arr = IntArray(n)
    var temp = if(n==1) 0 else 1
    if(  temp>m|| 9*n<m){
        println("${-1} ${-1}")
        return
    }
    repeat(n){
        val sum = m-arr.sum()
        for(i in 0 .. 9){
            if(n>1 && it==0 && i ==0)continue
            if(i+(arr.size-(it+1))*9<sum)continue
            arr[it]=i
            break
        }
    }
    arr.forEach { print(it) }
    print(" ")
    arr = IntArray(n)
    repeat(n){
        val sum = m-arr.sum()
        for(i in 9 downTo 0){
            if(n>1 && it==0 && i ==0)continue
            if(i>sum)continue
            arr[it]=i
            break
        }
    }
    arr.forEach { print(it) }

}