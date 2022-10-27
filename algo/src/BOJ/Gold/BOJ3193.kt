package BOJ.gold

import java.util.*

private lateinit var map: Array<CharArray>
private var x = 0
private var y = 0
private var pos = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, -1)
    this[3] = intArrayOf(0, 1)
}
private var pointer = 0

fun main() {
    val (n, k) = readLine()!!.split(" ").map(String::toInt)
    val stack = Stack<Char>()

    map = Array(n) { CharArray(n) }.apply {
        repeat(n) {
            this[it] = readLine()!!.toCharArray()
        }
    }
    val dir = CharArray(k).apply {
        repeat(k) {
            this[it] = readLine()!![0]
        }
    }

    var countD = 0
    var countL = 0

    //공찾기
    for (i in 0 until map.size) {
        for (j in 0 until map[i].size) {
            if (map[i][j] == 'L') {
                map[i][j] = '.'
                x = i
                y = j
            }
        }
    }

    for (i in dir) {
        fall(i)      //공떨어뜨리기

        if (stack.isEmpty()) {
            stack.add(i)
            if (i == 'D') countD++ else countL++
        } else if (stack.peek() != i) {
            if (stack.pop() == 'D') countD-- else countL--
        } else {
            stack.add(i)
            if (i == 'D') countD++ else countL++
        }

        if (countD == 4 || countL == 4) {
            repeat(4) {
                if (stack.pop() == 'D') countD-- else countL--
            }
        }
    }
    //표시
    map[x][y] = 'L'

    while (stack.isNotEmpty()) {
        map = turn(stack.pop())
    }
    for (i in map) {
        i.forEach { print("${it}") }
        println()
    }
}

private fun fall(dir: Char) {
    when (dir) {

        'D' -> {
            if (pointer == 0) pointer = 3
            else if (pointer == 1) pointer = 2
            else if (pointer == 2) pointer = 1
            else if (pointer == 3) pointer = 0
        }
        'L' -> {
            if (pointer == 0) pointer = 2
            else if (pointer == 1) pointer = 3
            else if (pointer == 2) pointer = 0
            else if (pointer == 3) pointer = 1
        }
    }
    while (true) {

        x += pos[pointer][0]
        y += pos[pointer][1]

        if (x<0||y<0||x>=map.size||y >= map.size || map[x][y] == 'X') {
            x -= pos[pointer][0]
            y -= pos[pointer][1]
            break
        }
    }
}

private fun turn(dir: Char): Array<CharArray> {
    val n = map.size
    val temp = Array(map.size) { CharArray(map.size) }
    when (dir) {
        'D' -> {
            for (i in 0 until temp.size) {
                for (j in 0 until temp.size) {
                    temp[j][n - 1 - i] = map[i][j]
                }
            }
        }
        'L' -> {
            for (i in 0 until temp.size) {
                for (j in 0 until temp.size) {
                    temp[n - 1 - j][i] = map[i][j]
                }
            }
        }
    }
    return temp
}