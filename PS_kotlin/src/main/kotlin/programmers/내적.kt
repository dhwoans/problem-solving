package programmers

class 내적 {
    fun solution(a: IntArray, b: IntArray): Int = a.zip(b).map{it.first * it.second}.sum()
}