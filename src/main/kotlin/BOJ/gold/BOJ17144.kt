package BOJ.gold

private lateinit var map: Array<IntArray>
private lateinit var order: ArrayList<dust>
private val dir = Array(4) { IntArray(2) }.apply {
    this[0] = intArrayOf(-1, 0)
    this[1] = intArrayOf(1, 0)
    this[2] = intArrayOf(0, -1)
    this[3] = intArrayOf(0, 1)
}//상 하 좌 우

fun main() {
    val br = System.`in`.bufferedReader()
    val (r, c, t) = br.readLine().split(" ").map { it.toInt() }
    map = Array(r) { IntArray(c) }

    repeat(r) {
        map[it] = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    }
    repeat(t) {
        order = ArrayList()
        //먼지확인
        for (i in 0 until map.size) {
            for (j in 0 until map[0].size) {
                if (map[i][j] >= 5) {
                    spread(i, j)
                }
            }
        }
        //먼지확산
        order.forEach { map[it.r][it.c] += it.dust }

        //공기청정기 작동
        for(i in 0 until map.size){
            if(map[i][0]==-1){
                run(i)
                break
            }
        }
    }
    //미세먼지 카운트
    val count =map.flatMap { it.toUIntArray() }.filter { it.toInt()>0 }.sum()
    println(count)


}

private fun spread(r: Int, c: Int) {
    var count = 0
    //확산 미세먼지 저장
    for (i in 0 until 4) {
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]

        if (nr < 0 || nc < 0 || nr >= map.size || nc >= map[0].size) continue
        if (map[nr][nc] != -1) {
            count++
            order.add(dust(nr, nc, map[r][c] / 5))
        }
    }
    //남은 미세먼지
    map[r][c] -= (map[r][c] / 5) * count
}

private fun run(r:Int){
    val up = listOf<Int>(0,3,1,2)
    val down = listOf<Int>(1,3,0,2)
    var nr = r
    var nc = 0
    for(i in 0 until up.size){
        while(true){

            nr += dir[up[i]][0]
            nc += dir[up[i]][1]
            if(i==2&&r<nr){
                nr-=1
                break
            }
            if(nr<0||nc<0||nr>=map.size||nc>=map[0].size){
                nr -= dir[up[i]][0]
                nc -= dir[up[i]][1]
                break
            }
            if(map[nr][nc]>0)swap(nr,nc,up[i])
        }
    }
    nr = r+1
    nc = 0
    for(i in  0 until down.size){
        while(true){
            nr += dir[down[i]][0]
            nc += dir[down[i]][1]
            if(i==2&&r+1>nr){
                nr+=1
                break
            }
            if(nr<0||nc<0||nr>=map.size||nc>=map[0].size){
                nr -= dir[down[i]][0]
                nc -= dir[down[i]][1]
                break
            }
            if(map[nr][nc]>0)swap(nr,nc,down[i])
        }
    }
}
private fun swap(r:Int,c:Int,wise:Int){
    var nx =r
    var ny =c
    when(wise){
        0->{
            nx+=dir[1][0]
            ny+=dir[1][1]
        }

        1->{
            nx+=dir[0][0]
            ny+=dir[0][1]
        }

        2->{
            nx+=dir[3][0]
            ny+=dir[3][1]
        }

        3->{
            nx+=dir[2][0]
            ny+=dir[2][1]
        }
    }
    if(map[nx][ny]==-1)map[r][c]=0
    else{
        val temp = map[r][c]
        map[r][c]= map[nx][ny]
        map[nx][ny] = temp
    }
}

private data class dust(val r: Int, val c: Int, val dust: Int)