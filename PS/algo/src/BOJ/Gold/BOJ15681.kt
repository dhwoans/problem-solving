package BOJ.Gold

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var size: IntArray

fun main() {
    val (n, r, q) = readln().split(" ").map { it.toInt() }
    size = IntArray(n + 1)

    arr = ArrayList<ArrayList<Int>>().apply {
        //노드
        repeat(n + 1) {
            this.add(ArrayList<Int>())
        }
        //엣지
        repeat(n - 1) {
            val (f, t) = readln().split(" ").map { it.toInt() }
            this[f].add(t)
            this[t].add(f)
        }
    }
    countSubtreeNodes(r)
    //쿼리
    val sb = StringBuilder()
    repeat(q) {
        val node = readln().toInt()
        sb.appendLine(size[node])
    }
    println(sb)
}

private fun countSubtreeNodes(currentNode: Int) {
    size[currentNode] += 1
    for (node in arr[currentNode]) {
        if (size[node] == 0) {
            countSubtreeNodes(node)
            size[currentNode] += size[node]
        }
    }

}