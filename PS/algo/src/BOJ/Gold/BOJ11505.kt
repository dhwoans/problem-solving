package BOJ.Gold

fun main() {
    val (n, m, k) = readln().split(" ").map { it.toInt() }
    val arr = IntArray(n).apply {
        repeat(n) {
            this[it] = readln().toInt()
        }
    }
    val seg = segmentTree(arr, LongArray(4 * n))
    seg.build(0, n - 1, 1)
    repeat(m + k) {
        val (a, b, c) = readln().split(" ").map { it.toInt() }
        when (a) {
            //변경
            1 -> {
                seg.update(0, n - 1, 1, b - 1, c)
                seg.arr[b - 1] = c
            }
            //구간곱 출력
            2 -> {
                val result = seg.query(0, n - 1, 1, b - 1, c - 1)
                println(result)
            }
        }
    }
}

private class segmentTree(val arr: IntArray, val tree: LongArray) {

    fun build(start: Int, end: Int, node: Int) {
        if (start == end) {
            this.tree[node] = this.arr[start].toLong()
            return
        }
        val mid = (start + end) / 2
        build(start, mid, node * 2)
        build(mid + 1, end, node * 2 + 1)
        tree[node] = (tree[node * 2] % 1_000_000_007 * tree[node * 2 + 1] % 1_000_000_007) % 1_000_000_007

        return
    }

    fun update(start: Int, end: Int, node: Int, i: Int, diff: Int) {
        //범위에서 벗어남
        if (start > i || end < i) {
            return
        }
        if (start == end) {
            this.tree[node] = diff.toLong()
            return
        } else if (start != end) {
            val mid = (start + end) / 2
            update(start, mid, node * 2, i, diff)
            update(mid + 1, end, node * 2 + 1, i, diff)
            this.tree[node] = (this.tree[node*2] % 1_000_000_007 * this.tree[node*2+1] % 1_000_000_007) % 1_000_000_007
        }
        return

    }

    fun query(start: Int, end: Int, node: Int, left: Int, right: Int): Long {
        //범위내
        if (left <= start && right >= end) {
            return this.tree[node]
        }
        //범위에 벗어남
        if (left > end || right < start) {
            return 1
        }
        val mid = (start + end) / 2
        val leftSum = query(start, mid, node * 2, left, right) % 1_000_000_007
        val rightSum = query(mid + 1, end, node * 2 + 1, left, right) % 1_000_000_007
        return (leftSum * rightSum) % 1_000_000_007
    }
}