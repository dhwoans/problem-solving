package programmers

class 나머지가1이되는수찾기 {
    fun solution(n: Int): Int = IntArray(n,{it->it+1}).filter { n%it==1 }.toIntArray().first()
}