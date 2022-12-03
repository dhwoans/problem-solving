package BOJ.Gold

import java.util.*

private lateinit var prime:BooleanArray
private var flag = false

fun main() {
    //소수체
    prime = BooleanArray(100_000)
    for(i in 2 until prime.size){
        if(prime[i])continue
        var j = 2
        while(i*j<prime.size){
            prime[i*j]=true
            j++
        }
    }

    repeat(readln().toInt()){
        flag = false
        val(from,to)=readln().split(" ")
        bfs(from,to)
        if(!flag){
            println("Impossible")
        }
    }
}

private fun bfs(from:String,to:String){
    val visited = BooleanArray(100_000)
    val que = LinkedList<Pair<String,Int>>()
    que.add(Pair(from,0))
    visited[from.toInt()]=true
    while(que.isNotEmpty()){
        val temp = que.poll()

        if(temp.first==to){
            flag = true
            println(temp.second)
            return
        }
        for(i in temp.first.indices ){
            val str = temp.first.toCharArray()
            for(j in 0 .. 9){
                if(i==0&&j==0)continue
                str[i]= Character.forDigit(j, 10)
                if (prime[String(str).toInt()]) continue
                if(visited[String(str).toInt()])continue
                visited[String(str).toInt()]=true
                que.add(Pair(String(str), temp.second + 1))
            }

        }
    }
}