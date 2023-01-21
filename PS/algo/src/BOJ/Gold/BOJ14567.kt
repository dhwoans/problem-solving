package BOJ.Gold

import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val (n,m)=readln().split(" ").map{it.toInt()}
    val indegree = IntArray(n+1)
    val arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n+1){
            this.add(ArrayList<Int>())
        }
        repeat(m){
            val (f,t)=readln().split(" ").map{it.toInt()}
            this[f].add(t)
            indegree[t]++
        }
    }
    //BFS
    val que = LinkedList<Int>()
    val ans = IntArray(n+1)
    var count = 1
    for(i in 1 until indegree.size){
        if(indegree[i]==0){
            que.add(i)
            ans[i]= count
        }
    }

    while(que.isNotEmpty()){
        count++
        val turn = que.size
        repeat(turn){
            val temp = que.poll()

            for(i in arr[temp]){
                if(--indegree[i]==0){
                    ans[i]=count
                    que.add(i)
                }
            }
        }
    }
    //print
    for(i in 1 until ans.size){
        print("${ans[i]} ")
    }

}