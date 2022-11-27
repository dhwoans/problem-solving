package BOJ.silver

import java.util.*

fun main() {
    val n = readLine()!!.toInt()
    val stack = Stack<Pair<Int,Int>>()
    var answer  =0
    repeat(n){
        val st = StringTokenizer(readLine())
        val task = st.nextToken().toInt()
        when(task){
            0->{
                if(stack.isEmpty())return@repeat
                val n = stack.pop()
                val pair = Pair(n.first,n.second-1)
                if(pair.second == 0)answer+=pair.first
                else stack.add(pair)
            }
            1->{
                val score = st.nextToken().toInt()
                val min = st.nextToken().toInt()-1
                if(min == 0)answer+= score
                else stack.add(Pair(score,min))
            }
        }
    }
    println(answer)
}