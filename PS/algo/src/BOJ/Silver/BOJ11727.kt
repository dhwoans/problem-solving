package BOJ.Silver

import kotlin.math.pow

fun main() {
    val n = readln().toInt()
    val mod = 10_007
    val arr = Array(1_001){IntArray(1_001)}
    for(i in arr.indices){
        for(j in arr.indices){
            if(i==j){
                arr[i][j]=1
                break
            }
            if(j==0)arr[i][j]=1
            else arr[i][j]=(arr[i-1][j]%mod+arr[i-1][j-1]%mod)%mod

        }
    }
    var num =n
    var count =1
    var sum =1
    if(n%2==0){
        while(count<num){
            var two =1
            repeat(count){two=(two*2)%mod}
            val ncm =arr[n-count][count]%mod
            sum=(sum%mod+(two%mod*ncm%mod))%mod

            count++
            num--
        }
    }else{
        while(count<num-1){
            var two =1
            repeat(count){two=(two*2)%mod}
            val ncm =arr[n-count][count]
            sum=(sum%mod+(two%mod*ncm%mod))%mod

            count++
            num--
        }
    }
    println(sum)
}