package programmers

class 두정수사이합 {
    fun solution(a: Int, b: Int): Long {
        var sum: Long = 0
        var start = a
        var end = b

        if(a>b){
            start = b
            end = a
        }

        for (i in start..end) {
            sum += i
        }
        return sum
    }
}