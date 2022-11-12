package BOJ.Silver

fun main() {
    var (n,k) =readln().split(" ").map(String::toInt)
    val arr = IntArray(n)
    var start = 0
    var end = arr.lastIndex
    var num =n
    while(true){
        if(num-1>k){
            arr[end]=num
            end--
            num--
        }else if(num-1<k){
            arr[start]=num
            num--
            start++
            k-=num
        }else if(num-1==k){
            arr[start]=num
            break
        }
    }
    var temp =1
    for(i in 0 until arr.size){
        if(arr[i]==0){
            arr[i] = temp++
        }
    }
    arr.forEach {
        print("$it ")
    }
}