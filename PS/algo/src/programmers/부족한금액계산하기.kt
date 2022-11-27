package programmers

class 부족한금액계산하기 {
    fun solution(price: Int, money: Int, count: Int): Long {
        var answer: Long = 0
        for (i in 1 .. count){
            answer+= price*i
        }
        answer -=money.toLong()
        if(answer<0)return 0
        return answer
    }
}