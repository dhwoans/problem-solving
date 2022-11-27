package programmers

class 나누어떨어지는숫자배열 {
    fun solution(arr: IntArray, divisor: Int): IntArray =
        if(arr.filter { it % divisor == 0 }.sorted().toIntArray().isEmpty()) arrayOf(-1).toIntArray()
        else arr.filter { it%divisor==0 }.sorted().toIntArray()
}