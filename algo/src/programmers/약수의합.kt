package programmers

class 약수의합 {
    fun solution(n: Int): Int = IntArray(n,{it->it+1}).filter { n % it == 0 }.toIntArray().sum()
}