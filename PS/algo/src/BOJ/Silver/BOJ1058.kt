package BOJ.silver

import java.util.*
import kotlin.math.max

private lateinit var visited:BooleanArray
private lateinit var rel:Array<CharArray>

fun main() {
    val n = readLine()!!.toInt()
    var answer = 0
    val num = ArrayList<Int>()
    rel = Array(n){CharArray(n)}.apply{
        repeat(n){
            this[it]= readLine()!!.toCharArray()
            num.add(this[it].count{i->i=='Y'})
        }
    }
    for(i in 0 until n){
        visited = BooleanArray(n)
        visited[i]=true
        answer  =  max(answer,dfs(i))


    }
}

private fun dfs(i:Int):Int{
    var count =0
    val que:Queue<Pair<Int,Int>> = LinkedList()
    que.add(Pair(i,0))
    while(que.isNotEmpty()){
        val temp =que.poll()
        if(temp.second==2)return count
        for(j in 0 until rel[temp.first].size){
            if(rel[temp.first][j]=='Y'&&!visited[j]){
                visited[j]=true
                que.add(Pair(j,temp.second+1))
                count++
            }
        }
    }
    return count
}