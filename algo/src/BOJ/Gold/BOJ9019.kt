package BOJ.Gold

import java.util.*


private lateinit var visited: BooleanArray
private lateinit var que:Queue<Pair<Int,String>>

fun main() {
    repeat(readLine()!!.toInt()) {
        val (from, to) = readLine()!!.split(" ").map(String::toInt)
        bfs(from, to)
    }
}



private fun bfs(from: Int, to: Int) {
    visited = BooleanArray(10_000)
    que = LinkedList()
    que.add(Pair(from,""))

    while (que.isNotEmpty()) {
        val temp = que.poll()

        if (temp.first == to) {
            println(temp.second)
            return
        }
        Dcommand(temp)
        Scommand(temp)
        Lcommand(temp)
        Rcommand(temp)
    }
}

private fun Rcommand(temp: Pair<Int,String>) {
    val num1 = temp.first /10
    val num2 = temp.first %10
    if(visited[num2*1000+num1])return
    else{
        visited[num2*1000+num1]=true
        que.add(Pair(num2*1000+num1,temp.second+"R"))
    }

}

private fun Lcommand(temp: Pair<Int,String>) {
    val num1 = temp.first / 1000
    val num2 = temp.first % 1000
    if(visited[num2*10+num1])return
    else{
        visited[num2*10+num1]=true
        que.add(Pair(num2*10+num1,temp.second+"L"))
    }


}

private fun Scommand(temp: Pair<Int,String>) {
    val num = if(temp.first-1<0) 9999 else temp.first-1
    if(visited[num])return
    else{
        visited[num]=true
        que.add(Pair(num,temp.second+"S"))
    }
}

private fun Dcommand(temp: Pair<Int,String>) {
    if (visited[(temp.first * 2) % 10000]) return
    else{
        visited[(temp.first*2)%10000]=true
        que.add(Pair((temp.first*2)%10000,temp.second+"D"))
    }
}