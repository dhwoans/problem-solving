package BOJ.silver

val count = 0
var white = 0
var blue = 0
lateinit var map: Array<IntArray>

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    //색종이 정보
    map = Array(n) { IntArray(n) }
    repeat(n) {
        map[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }

    search(0, 0, n)
    println(white)
    println(blue)

}

fun search(r: Int, c: Int, n: Int) {
    val color = map[r][c]
    var isPaper = true
    out@ for (i in r until r + n) {
        for (j in c until c + n)
            if (map[i][j] != color) {
                isPaper = false
                break@out
            }
    }

    if (!isPaper) {
        search(r, c, n / 2)//1사분면
        search(r+n / 2, c, n / 2)//2사분면
        search(r, c+n / 2, n / 2)//3사분면
        search(r+n / 2, c+n / 2, n / 2)//4사분면
    }else{
        if(color==0)white++ else blue++
    }

}
