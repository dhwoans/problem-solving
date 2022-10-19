package BOJ.gold

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

private lateinit var map: Array<IntArray>
private lateinit var visited: Array<IntArray>
private val dir = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, 1)
    this[3] = intArrayOf(0, -1)
}

fun main() {
    val sb = StringBuilder()
    val (n, m) = readLine()!!.split(" ").map(String::toInt)
    visited = Array(n) { IntArray(m) }
    map = Array(n) { IntArray(m) }.apply {
        for(i in 0 until n){
            val str = readLine()!!
            for(j in 0 until m){
                this[i][j]=str[j]-'0'
            }
        }
    }
    //구역나누기
    var cnt = 0
    val area = ArrayList<Int>().apply{this.add(0)}

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (visited[i][j]==0 && map[i][j] == 0) {
                cnt++
                val value = dfs(i, j, cnt)
                area.add(value)
            }
        }
    }

    for (i in 0 until n) {
        for (j in 0 until m) {
            if (map[i][j] == 1) {
                val set = HashSet<Int>()
                var sum =1
                for (k in dir) {
                    val nx = i + k[0]
                    val ny = j + k[1]

                    if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
                    if(visited[nx][ny]!=0){
                        set.add(visited[nx][ny])
                    }
                }
                set.forEach { sum+=area[it] }
                map[i][j]=sum%10

            }
            sb.append(map[i][j])
        }
        sb.appendLine()
    }
    println(sb)
}
fun dfs(x: Int, y: Int, cnt: Int): Int {
    var result = 1
    val que = LinkedList<IntArray>()
    que.add(intArrayOf(x,y))
    visited[x][y] = cnt

    while(!que.isEmpty()){
        val temp = que.poll()

        for (i in dir) {
            val nx = temp[0] + i[0]
            val ny = temp[1] + i[1]

            //범위체크
            if (nx < 0 || ny < 0 || nx >= map.size || ny >= map[0].size) continue
            if (visited[nx][ny] != 0) continue
            if (map[nx][ny] == 0){
                visited[nx][ny] = cnt
                que.add(intArrayOf(nx,ny))
                result++
            }

        }
    }
    return result
}