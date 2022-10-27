package codeforces

import java.util.*
import kotlin.math.abs

class Solution {
    fun findClosestElements(arr: IntArray, k: Int, x: Int): List<Int> {
        val answer = ArrayList<Int>()
        val que = PriorityQueue<Pair<Int, Int>>(compareBy<Pair<Int, Int>> { it.second }.thenBy { it.first })
        for(i in arr){
            que.add(Pair(i,abs(x-i)))
        }
        repeat(k){
            answer.add(que.poll().first)
        }
        answer.sort()
        return answer
    }
}