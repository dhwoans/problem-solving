package BOJ.gold

private lateinit var map: Array<IntArray>
private lateinit var col: Array<BooleanArray>
private lateinit var raw: Array<BooleanArray>
private lateinit var square: Array<BooleanArray>
private lateinit var zero: ArrayList<IntArray>
private var flags:Boolean = false


fun main() {
    val br = System.`in`.bufferedReader()

    map = Array(9) { IntArray(9) }
    raw = Array(9) { BooleanArray(10) }
    col = Array(9) { BooleanArray(10) }
    square = Array(9) { BooleanArray(10) }
    zero = ArrayList()

    for (i in 0 until map.size) {
        val str = br.readLine().toString()
        for (j in 0 until str.length) {
            map[i][j] = str[j] - '0'
            if (map[i][j] == 0) zero.add(intArrayOf(i, j))
        }
    }

    //행 열 체크
    for (i in 0 until map.size) {
        for (j in 0 until map[i].size) {
            if (map[i][j] == 0) continue
            raw[i][map[i][j]] = true
            col[j][map[i][j]] = true
        }
    }

    //3x3체크
    for (i in 0 until map.size) {
        for (j in 0 until map[i].size) {
            if (map[i][j] == 0) continue
            square[convertPos(i, j)][map[i][j]] = true
        }
    }

    //스도쿠 시작
    check(0)

    for (i in map) {
        for (j in i) {
            print(j)
        }
        println()
    }

}

private fun check(cnt: Int) {
    if (cnt == zero.size) {
        flags = true
        return
    }else{
        val x = zero.get(cnt)[0]
        val y = zero.get(cnt)[1]

        for (j in 1..9) {
            if (raw[x][j] || col[y][j] || square[convertPos(x, y)][j]) continue
            map[x][y] = j
            raw[x][j]=true
            col[y][j]=true
            square[convertPos(x, y)][j]=true
            check(cnt + 1)
            if(flags) return
            map[x][y]=0
            raw[x][j]=false
            col[y][j]=false
            square[convertPos(x, y)][j]=false
        }
    }
}


private fun convertPos(i: Int, j: Int): Int {
    return when {
        (i > 5) -> {
            if (j > 5) 8
            else if (j > 2) 7
            else 6
        }
        (i > 2) -> {
            if (j > 5) 5
            else if (j > 2) 4
            else 3
        }
        else -> {
            if (j > 5) 2
            else if (j > 2) 1
            else 0
        }
    }
}