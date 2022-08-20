package programmers

class 문자열을정수로바꾸기 {
    fun solution(s: String): Int {
//        var answer = 0
//        var sign = ""
//        var num:Int = s.toInt()
//        if (s[0] > '9') {
//            sign = s.substring(0, 1)
//            num = s.substring(1).toInt()
//        }
//        if (sign.equals("-")) {
//            num *= -1
//        }
//        return num
        return when(s[0]){
            '+'->s.substring(1).toInt()
            '-'->s.substring(1).toInt() * (-1)
            else ->s.toInt()
        }
    }
}