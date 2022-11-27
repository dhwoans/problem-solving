package programmers

class 자연수뒤집어배열로만들기 {
    fun solution(n: Long): IntArray = n.toString().reversed().map { it.toString().toInt() }.toIntArray()
}
