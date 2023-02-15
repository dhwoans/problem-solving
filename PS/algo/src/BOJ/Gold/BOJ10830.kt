package BOJ.Gold

private val MOD = 1_000
private lateinit var arr: Array<IntArray>
fun main() {
    val (n, b) = readln().split(" ").map { it.toLong() }
    arr = Array(n.toInt()) { IntArray(n.toInt()) }
    repeat(n.toInt()) {
        arr[it] = readln().split(" ").map { it.toInt()%MOD}.toIntArray()
    }
    //분할정복
    val ans = pow(arr, b)
    //출력
    for (i in ans) {
        for (j in i) {
            print("$j ")
        }
        println()
    }
}

private fun pow(a: Int, exponant: Long): Array<IntArray> {
    if (exponant == 1L) {
        return a
    }

    var ans = pow(a, exponant / 2)
    ans = mul(ans, ans)
    if (exponant % 2 == 1L) {
        ans = mul(ans, arr)
    }
    return ans
}

private fun mul(a: Array<IntArray>, b: Array<IntArray>): Array<IntArray> {
    val result = Array(arr.size) { IntArray(arr.size) }

    for (i in arr.indices) {
        for (j in arr.indices) {
            for (k in arr.indices) {

                result[i][j] += a[i][k] * b[k][j]
                result[i][j] %= MOD
            }
        }
    }
    return result
}