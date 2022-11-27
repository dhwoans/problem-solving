package programmers

import kotlin.math.sqrt

class 정수제곱근판별 {
    fun solution(n: Long): Long {
        val answer = sqrt(n.toDouble())
        if (answer % 1.0 == 0.0) {

            return ((answer + 1) * (answer + 1)).toLong()
        }
        return -1L
    }
}