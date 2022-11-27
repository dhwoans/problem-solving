package programmers

class 이천십육년 {
    fun solution(a: Int, b: Int): String {
        val dayArray = arrayOf("FRI","SAT","SUN","MON","TUE","WED","THU")
        val month = intArrayOf(0,31,29,31,30,31,30,31,31,30,31,30,31)
        val sumDay = month.copyOfRange(1,a).sum().plus(b).minus(1).mod(7)
        var answer = dayArray[sumDay]
        return answer
    }
}