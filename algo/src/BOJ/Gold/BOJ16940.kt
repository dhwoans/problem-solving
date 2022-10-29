import java.util.*
import kotlin.collections.ArrayList

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var visited: BooleanArray
private lateinit var check: IntArray

fun main() {
    val n = readLine()!!.toInt()
    arr = ArrayList<ArrayList<Int>>().apply {
        repeat(n + 1) {
            this.add(ArrayList<Int>())
        }
        repeat(n - 1) {
            val (from, to) = readLine()!!.split(" ").map { it.toInt() }
            this[from].add(to)
            this[to].add(from)
        }
    }
    check = readLine()!!.split(" ").map(String::toInt).toIntArray()
    visited = BooleanArray(n + 1)
    visited[1] = true
    if (check[0] != 1) {
        println(0)
        return
    }
    val answer = bfs()

    if (answer) {
        println(1)
    } else {
        println(0)
    }
}

private fun bfs(): Boolean {
    val que: Queue<Int> = LinkedList<Int>()
    que.add(1)
    var cnt = 1
    while (que.isNotEmpty()) {
        var n = 0

        val temp = que.poll()

        for (k in arr[temp]) {
            if (visited[k]) continue
            visited[k] = true
            n++
        }
        //검사
        repeat(n) {
            val num = check[cnt++]
            if (!visited[num]) {
                return false
            } else {
                que.add(num)
            }
        }
    }
    return true
}