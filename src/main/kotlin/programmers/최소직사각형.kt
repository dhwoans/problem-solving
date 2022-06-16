package programmers

class 최소직사각형 {
    fun solution(sizes: Array<IntArray>): Int {
        for (size in sizes){
            if(size[0] >size[1]){
                val temp = size[0]
                size[0] = size[1]
                size[1] = temp
            }
        }
        val row =sizes.map { it[0] }.maxOrNull();
        val col =sizes.map { it[1]}.maxOrNull();
        println("$row $col")
        return row!! *col!!
    }
}