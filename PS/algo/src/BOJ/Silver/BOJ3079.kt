package BOJ.Silver

fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    val arr = ArrayList<Int>()
    repeat(n){
        arr.add(readln().toInt())
    }

    var start:Long =1
    var end:Long =1_000_000_000_000_000_000

    while(start<=end){
        val mid = (start+end)/2
        var sum =0L
        for(i in arr){
            sum += mid/i
            if (sum >= m) break
        }
        if(sum>=m){
            end = mid-1
        }else{
            start = mid+1
        }
    }
    println(start)
}
