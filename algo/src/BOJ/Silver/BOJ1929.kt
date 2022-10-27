package BOJ.silver
private lateinit var arr:BooleanArray

fun main() {
    arr = BooleanArray(1_000_001)
    arr[1]=true
    for(i in 2..arr.lastIndex){
        if(arr[i])continue
        for(j in 2..arr.lastIndex/i){
            if(i*j<=arr.lastIndex)arr[i*j]=true
            else continue
        }
    }
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    for(i in n..m){
        if(!arr[i]) println(i)
    }
}