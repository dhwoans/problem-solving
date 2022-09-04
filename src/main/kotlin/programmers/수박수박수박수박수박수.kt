package programmers

class 수박수박수박수박수박수 {
    fun solution(n: Int): String {
        var answer =""
        for(i:Int in 0 until n){
            when(i%2){
                0 -> answer+="수"
                else -> answer +="박"
            }
        }
        return answer
    }
}