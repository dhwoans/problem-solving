package BOJ.Silver

fun main() {
    var arr = IntArray(100_001){1}
    arr[1]=0
    arr[0]=0
    for(i in 2 until arr.size){
        for(j in 2 until arr.size){
            if (i * j >= arr.size)break
            arr[i*j]=arr[i]+arr[j]
        }
    }
    val (a,b)= readLine()!!.split(" ").map(String::toInt)
    var count =0
    for(i in a .. b){
        if(arr[arr[i]]==1){
            count++
        }
    }
    println(count)
}