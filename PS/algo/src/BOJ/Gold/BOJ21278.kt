package BOJ.Gold

import java.util.*
import kotlin.math.min

fun main() {
    val(n,m) = readln().split(" ").map{it.toInt()}
    val arr = Array(n){IntArray(n){987654321}}.apply{
        repeat(n){
            this[it][it]=0
        }
    }

    repeat(m){
        val (f,t)= readln().split(" ").map{it.toInt()-1}
        arr[f][t]=1
        arr[t][f]=1
    }

    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                arr[i][j] = min(arr[i][j],arr[i][k]+arr[k][j])
            }
        }
    }

    var ans = Int.MAX_VALUE
    var ansi = -1
    var ansj = -1
    for(i in 0 until n){
        for(j in i until n){
            var sum =0
            for(k in 0 until n){
                if(k==i || k==j)continue
                else {
                    sum+= min(arr[i][k],arr[j][k])
                }
            }
            if(ans > sum){
                ansi=i
                ansj=j
                ans = sum
            }

        }
    }
    println("${ansi+1} ${ansj+1} ${ans*2}")
}
