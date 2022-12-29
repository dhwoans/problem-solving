package BOJ.Gold

import java.util.*
import kotlin.collections.*


fun main() {
    val n = readln().toInt()
    val indegree = IntArray(n+1)
    val visited = IntArray(n+1)
    val ans = IntArray(n+1)
    val arr = ArrayList<ArrayList<Pair<Int,Int>>>().apply{
        repeat(n+1){
            this.add(ArrayList())
        }
        repeat(readln().toInt()) {
            val (p, q, r) = readln().split(" ").map { it.toInt() }
            this[p].add(Pair(q,r))
            indegree[q]++
        }
    }
    val que = LinkedList<Triple<Int,Int,Int>>()

    que.add(Triple(1,0,0))
    while(que.isNotEmpty()){
        val temp = que.poll()
        //종료
        if(temp.first==1&&indegree[temp.first]==0)break

        for(i in arr[temp.first]){

            //최대값 저장
            if (visited[i.first]<i.second+visited[temp.first]) {
                visited[i.first] = i.second+visited[temp.first]
                ans[i.first]=temp.first
            }
            if(--indegree[i.first]==0){
                que.add(Triple(i.first,visited[i.first],temp.third+1))
            }
        }
    }
    println(visited[1])
    //추적
    val stack = Stack<Int>()
    stack.add(ans[1])
    var x = ans[1]
    while(x != 1){
        x = ans[x]
        stack.add(x)
    }
    while(stack.isNotEmpty()){
        print("${stack.pop()} ")
    }
    print("1 ")
}