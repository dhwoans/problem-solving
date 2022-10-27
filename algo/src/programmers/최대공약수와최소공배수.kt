package programmers

class 최대공약수와최소공배수 {
    fun solution(n: Int, m: Int): IntArray {
        var answer = IntArray(2)
        var big = if(n>m) n else m
        var small = if(n>m) m else n
        answer[1]= big*small

        while(true){
            var temp = big%small
            big = small
            small = temp
            if(small ==0){
                println(answer[1])
                answer[0]=  big
                answer[1]= m*n/big
                break
            }
        }
        return answer
    }
}