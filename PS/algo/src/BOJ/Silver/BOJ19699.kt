package BOJ.Silver

import java.util.*

private lateinit var visited: BooleanArray
private lateinit var prime: BooleanArray
private lateinit var arr: IntArray
private val ans = TreeSet<Int>()
fun main() {
    //prim
    prime = BooleanArray(10_000)
    for (i in 2 until prime.size) {
        if (prime[i]) continue
        var j = 2
        while (i * j < prime.size) {
            prime[i*j]=true
            j++
        }
    }

    //dfs
    val (n, m) = readln().split(" ").map { it.toInt() }
    arr = readln().split(" ").map { it.toInt() }.toIntArray()
    visited = BooleanArray(n)
    permutation(0,0,m)
    if(ans.size!=0){
        ans.forEach {
            print("$it ")
        }
    }else{
        println(-1)
    }
}

private fun permutation(cnt: Int,start:Int, end: Int) {
    if (cnt == end) {
        cal()
        return
    }
    for (i in start until visited.size) {
        if (visited[i]) continue
        visited[i] = true
        permutation(cnt + 1,i, end)
        visited[i] = false
    }
}

private fun cal() {
    var sum = 0
    for (i in visited.indices) {
        if (visited[i]) {
            sum += arr[i]
        }
    }
    if(!prime[sum])ans.add(sum)
}