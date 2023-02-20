package BOJ.Gold

fun main() {
    //primenum
    val check = BooleanArray(4_000_001)
    val prime = ArrayList<Int>()
    for(i in 2 until check.size){
        if(check[i])continue
        prime.add(i)
        var j =2
        while(i*j<check.size){
            check[i*j]=true
            j++
        }
    }
    //two pointer
    val n = readln().toInt()
    var count =0
    var sum  = 0
    var start =0
    var end =0
    while(start < prime.size){
        if(end >=prime.size){
            sum-=prime[start++]
            if(sum==n)count++
        }else{
            if(sum<n){
                sum+=prime[end++]
            }else{
                if(sum==n)count++
                sum-=prime[start++]

            }
        }
    }
    println(count)
}