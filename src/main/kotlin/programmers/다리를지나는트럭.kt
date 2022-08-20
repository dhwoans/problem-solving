package programmers

import java.util.*

class 다리를지나는트럭 {
    fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int{
        var answer = 0
        val que = LinkedList<Int>()
        val wait = LinkedList<Int>()
        for(i in truck_weights){
            wait.add(i)
        }
        repeat(bridge_length){que.add(0)}

        while(que.isNotEmpty()){
            que.pop()
            answer++
            if(wait.isNotEmpty()&&weight<que.sum()+wait.peek())que.add(0)
            else if(wait.isNotEmpty())que.add(wait.pop())
        }
        return answer
    }
}