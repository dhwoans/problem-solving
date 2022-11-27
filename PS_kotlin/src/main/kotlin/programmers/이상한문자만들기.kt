package programmers

class 이상한문자만들기 {
    fun solution(s: String): String = s.split(" ").
    joinToString(" ") { s->
        s.mapIndexed{ index, c -> if(index%2==0) c.uppercase() else c.lowercase()
        }
            .joinToString("") }

}