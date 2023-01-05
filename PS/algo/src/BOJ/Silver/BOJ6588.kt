package BOJ.Silver

fun main() {
    //소수체
    val isPrime = BooleanArray(100_0001){true}
    isPrime[0]=false
    isPrime[1]=false
    isPrime[2]=false

    for(i in 2 until isPrime.size){
        var j =2
        while(i*j<isPrime.size){
            isPrime[i*j]=false
            j++
        }
    }
    while(true){
        val n  = readln().toInt()
        if(n==0)break
        for(i in 3 .. n/2){
            if(isPrime[i]&&isPrime[n-i]){
                println("${n} = ${i} + ${n-i}")
                break
            }
        }
    }
}