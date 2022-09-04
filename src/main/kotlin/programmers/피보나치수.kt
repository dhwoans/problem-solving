package programmers

class 피보나치수 {
    fun solution(n: Int): Int {
        var answer = Array<Int>(n+1){1}
        (3..n).forEach{answer[it]=(answer[it-1]+answer[it-2])%1234567}
        return answer[n]
    }
}