import kotlin.math.pow

fun main(args: Array<String>) {

}

fun solution(today: String, terms: Array<String>, privacies: Array<String>): IntArray {
    val answer: ArrayList<Int> = ArrayList()
    val (ty, tm, td) = today.split(".").map(String::toInt)
    val map = HashMap<String, Int>().apply {
        repeat(terms.size) {
            val (a, b) = terms[it].split(" ")
            this[a] = b.toInt()
        }
    }
    repeat(privacies.size) {
        val (date, term) = privacies[it].split(" ")
        var (y, m, d) = date.split(".").map(String::toInt)
        m += map[term]!!
        if (m > 12) {
            y += m/12
            m %= 12

        }
        if(d==1){
            m--
            d=28
        } else d--

        println("${y} ${m} ${d}")
        if (ty > y || ty == y && tm > m || ty == y && tm == m && td > d) {
            answer.add(it+1)
        }
    }
    return answer.toIntArray()
}