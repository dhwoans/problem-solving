package BOJ.Gold

private lateinit var root: IntArray

fun main() {
    val n = readln().toInt()
    root = IntArray(n + 1).apply {
        repeat(this.size) {
            this[it] = it
        }
    }
    var count = 0
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val m = find(n)
        if (m != 0) {
            union(m,m-1)
            count++
        }else{
            println(count)
            return
        }
    }
    println(count)
}

private fun find(a: Int): Int {
    return if (root[a] == a) {
        a
    } else {
        root[a] = find(root[a])
        return root[a]
    }
}

private fun union(a: Int, b: Int) {
    root[find(a)] = find(b)
}

