package programmers

import java.util.Arrays
import java.util.Comparator

class 정수내림차순으로배치하기 {
    fun solution(n: Long): Long {
        var answer: Long = 0
        var temp:Long =n
        var arr = ArrayList<Long>();
        while(temp!=0L){
            arr.add(temp%10)
            temp/=10
        }
        arr.sortWith(reverseOrder())
        for (l in arr) {
            answer= answer*10+l
        }
        return answer
    }
}