package programmers

import java.util.*

fun main(){
    val answer = Solution().solution("4177252841",4)
    println(answer)
}
class Solution {
    fun solution(number: String, k: Int): String {
        var answer = ""
        var count = k
        val stack = Stack<Int>()
        for(v in number){
            val i = v-'0'
            if(count==0){
                stack.add(i)
                continue
            }

            if(stack.isEmpty())stack.add(i)
            else if(stack.peek()<i){
                while(stack.isNotEmpty()&& stack.peek()<i && count!=0){
                    if(stack.peek()<i){
                        stack.pop()
                        count--
                    }
                }
                stack.add(i)
            }else{
                stack.add(i)
            }
        }
        stack.forEachIndexed{index,i -> if(index<number.length-k)answer+=i}
        return answer
    }
}