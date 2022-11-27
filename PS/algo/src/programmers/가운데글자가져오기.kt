package programmers

class 가운데글자가져오기 {
    fun solution(s: String): String = if (s.length %2 ==0) s[s.length/2].toString()
        else s[s.length/2]+s[s.length/2+1].toString()
}