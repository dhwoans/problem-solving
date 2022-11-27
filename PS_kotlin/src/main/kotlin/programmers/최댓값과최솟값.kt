package programmers

class 최댓값과최솟값 {
    fun solution(s: String): String {
        val arr =s.split(" ").map{it.toInt()}.toIntArray()

        return  arr.minOrNull().toString() +" "+ arr.maxOrNull().toString()
    }
}