package BOJ.gold

import java.util.LinkedList
import java.util.Queue

private val dir = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, -1)
    this[3] = intArrayOf(0, 1)
}
private lateinit var switch: ArrayList<ArrayList<Int>>
private lateinit var light: Array<BooleanArray>
fun main() {
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    light = Array(n) { BooleanArray(n) }.apply{
        this[0][0] = true
    }
    switch = ArrayList<ArrayList<Int>>().apply {
        repeat(n * n) {
            this.add(ArrayList())
        }
        // 스위치 정보
        repeat(m) {
            val (x, y, a, b) = readLine()!!.split(" ").map { it.toInt() - 1 }
            this[x * n + y].add(a * n + b)
        }
    }
    //bfs
    val answer =bfs(n)
    println(answer+1)

}

private fun bfs(n: Int):Int {
    var count = 0
    var turnOn = false;

    val visited = Array(n) { BooleanArray(n) }
    val que: Queue<IntArray> = LinkedList()
    que.add(intArrayOf(0, 0))

    while (!que.isEmpty()) {
        val temp = que.poll()

        //불을 켠다
        for (i in switch[temp[0] * n + temp[1]]) {
            if(light[i/n][i%n])continue //이미 불켜짐
            light[i / n][i % n] = true
            turnOn =true
            count++
        }
        for (i in dir) {
            val nx = temp[0] + i[0]
            val ny = temp[1] + i[1]
            if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue    //범위
            if (visited[nx][ny]) continue //방문
            if (!light[nx][ny]) continue //불켜짐
            visited[nx][ny] = true
            que.add(intArrayOf(nx, ny))
        }
    }
    if(turnOn){
        return bfs(n)+count
    }
    return count
}