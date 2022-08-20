package BOJ.gold

private lateinit var map: Array<IntArray>
private val dir: Array<IntArray> = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(0, -1)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, 1)
    this[3] = intArrayOf(-1, 0)
}// 왼 아 오 위
private val diagonal: Array<IntArray> = Array(4) { IntArray(2)}.apply {
    this[0] = intArrayOf(-1,1)
    this[1] = intArrayOf(-1,-1)
    this[2] = intArrayOf(1,1)
    this[3] = intArrayOf(1,-1)
}// 위오 위왼 아오 아왼
private var amount = 0

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    var r = n / 2
    var c = n / 2
    var count = 0
    var point = -1
    map = Array(n) { IntArray(n) }
    var turn = 1
    //맵
    repeat(n) { map[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray() }
    //이동
    out@ while (true) {
        //탈출조건

        //방향바꿈
        if (point < 3) point++
        else point = 0
        //횟수증가
        if (count >= 2) {
            count = 1
            turn++
        } else count++

        for (i in 0 until turn) {
            val nr = r + dir[point][0]
            val nc = c + dir[point][1]

            if (nr == 0 && nc < 0) break@out
            spread(nr, nc, point)
            map[nr][nc]=0
            r = nr
            c = nc

        }
    }
    println(amount)
}

private fun spread(r: Int, c: Int, point: Int) {
    var order = IntArray(2)
    val seven = (map[r][c]*0.07).toInt()
    val ten = (map[r][c]*0.1).toInt()
    val one = (map[r][c]*0.01).toInt()
    val two = (map[r][c]*0.02).toInt()
    val five = (map[r][c]*0.05).toInt()
    var alpha = 0
    var v1 = -1
    var v2 = -1
    var v3 = -1
    var v4 = -1
    // 왼 아 오 위
    // 위오 위왼 아오 아왼
    when(point){
        0 ->{//1 //3
            order = intArrayOf(1,3)
            v1 = one
            v2 = ten
            v3 = one
            v4 = ten
        }

        1 ->{//0 //2
            order = intArrayOf(0,2)
            v1 = one
            v2 = one
            v3 = ten
            v4 = ten
        }

        2 ->{
            order = intArrayOf(1,3)
            v1 = ten
            v2 = one
            v3 = ten
            v4 = one
        }

        3 ->{
            order = intArrayOf(0,2)
            v1 = ten
            v2 = ten
            v3 = one
            v4 = one
        }
    }
    for(i in order){
            if(outOfRange(r+dir[i][0],c+dir[i][1])){
                amount+=seven
                alpha+=seven
            } else{
                map[r+dir[i][0]][c+dir[i][1]]+=seven
                alpha+=seven
            }
            if(outOfRange(r+dir[i][0]*2,c+dir[i][1]*2)){
                amount+=two
                alpha+=two
            } else{
                map[r+dir[i][0]*2][c+dir[i][1]*2]+=two
                alpha+=two
            }
    }
    if(outOfRange(r+ diagonal[0][0],c+ diagonal[0][1])){
        amount += v1
        alpha+=v1
    } else{
        map[r+ diagonal[0][0]][c+ diagonal[0][1]]+= v1
        alpha+=v1
    }
    if(outOfRange(r+ diagonal[1][0],c+ diagonal[1][1])){
        amount += v2
        alpha+=v2
    } else{
        map[r+ diagonal[1][0]][c+ diagonal[1][1]]+= v2
        alpha+=v2
    }
    if(outOfRange(r+ diagonal[2][0],c+ diagonal[2][1])){
        amount += v3
        alpha+=v3
    } else{
        map[r+ diagonal[2][0]][c+ diagonal[2][1]]+= v3
        alpha+=v3
    }
    if(outOfRange(r+ diagonal[3][0],c+ diagonal[3][1])){
        amount += v4
        alpha+=v4
    } else{
        map[r+ diagonal[3][0]][c+ diagonal[3][1]]+= v4
        alpha+=v4
    }
    if(outOfRange(r+dir[point][0]*2,c+dir[point][1]*2)){
        amount+=five
        alpha+=five
    } else{
        map[r+dir[point][0]*2][c+dir[point][1]*2]+=five
        alpha+=five
    }
    if(outOfRange(r+dir[point][0],c+dir[point][1])){
        amount+=(map[r][c]-alpha)
    } else{
        map[r+dir[point][0]][c+dir[point][1]]+=(map[r][c]-alpha)
    }
}

private fun outOfRange(r:Int,c:Int):Boolean{
    return r<0||c<0||r>=map.size||c>=map[0].size
}
