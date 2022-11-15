package BOJ.Gold

fun main() {
    val (n, m) = readln().split(" ").map(String::toInt)
    val plus = ArrayList<Int>()
    val minus = ArrayList<Int>()
    val sum = ArrayList<Int>()
    readln().split(" ").map(String::toInt).forEach {
        if (it < 0) {
            minus.add(it * -1)
        } else {
            plus.add(it)
        }
    }
    plus.sortDescending()
    for (i in plus.indices) {
        if (i % m == 0) {
            sum.add(plus[i])
        }
    }
    minus.sortDescending()
    for (i in minus.indices) {
        if (i % m == 0) {
            sum.add(minus[i])
        }
    }
    sum.sortDescending()
    var ans = 0
    for (i in sum.indices) {
        ans += if (i == 0) {
            sum[i]
        } else {
            2 * sum[i]
        }
    }
    println(ans)
}