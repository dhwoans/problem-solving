package programmers

class 수박수박수박수박수박수 {
    fun solution(n: Int): String {
        var answer =""
        for(i:Int in 1 until n){
            when(n%2){
                0 -> answer+="수"
                else -> answer +="박"
            }
        }
        return answer
    }
}