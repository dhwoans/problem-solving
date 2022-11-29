import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private lateinit var arr: ArrayList<ArrayList<Int>>
private lateinit var a: IntArray
private lateinit var visited: BooleanArray
private lateinit var dis: IntArray
private lateinit var set: HashSet<Int>
var flag = false

fun main() {
    val n = readln().toInt()
    arr = ArrayList<ArrayList<Int>>()
    a = IntArray(6_000) { -1 }
    repeat(n) {
        arr.add(ArrayList())
    }
    repeat(n) {
        val (from, to) = readln().split(" ").map { it.toInt() - 1 }
        arr[from].add(to)
        arr[to].add(from)
    }
    //순환찾기
    visited = BooleanArray(n)
    dfs( 0, 0, 0)


    set = HashSet<Int>()
    for (i in a.lastIndex downTo 0) {
        if (a[i] == -1) continue
        if(set.contains(a[i]))break
        set.add(a[i])

    }

    dis = IntArray(n)
    //최단거리찾기
    for (i in 0 until n) {
        if (set.contains(i)) continue
        dis[i] = bfs(i, n)
    }
    dis.forEach {
        print("${it} ")
    }
}

private fun dfs(next: Int, pre: Int, cnt: Int) {
    a[cnt] = next
    if (visited[next]) {
        flag = true
        return
    } else {
        visited[next]=true
        for (i in arr[next]) {
            if (i == pre) continue
            dfs(i, next, cnt + 1)
            if(flag)return
        }
        a[cnt]=-1
    }
}

private fun bfs(i: Int, n: Int): Int {
    visited = BooleanArray(n)
    val que: Queue<Pair<Int, Int>> = LinkedList()
    visited[i] = true
    que.add(Pair(i, 0))
    while (que.isNotEmpty()) {
        val temp = que.poll()

        if (set.contains(temp.first)) {
            return temp.second
        }
        for (next in arr[temp.first]) {
            if (visited[next]) continue
            visited[next] = true
            que.add(Pair(next, temp.second + 1))
        }
    }
    return -1
}