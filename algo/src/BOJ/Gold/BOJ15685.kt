package BOJ.gold

import java.util.Stack

private lateinit var map:Array<IntArray>
private val  dir = Array(4){IntArray(2)}.apply {
    this[0] = intArrayOf(0,1)
    this[1] = intArrayOf(-1,0)
    this[2] = intArrayOf(0,-1)
    this[3] = intArrayOf(1,0)
}
fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    map = Array(101){ IntArray(101) }

    //드래곤 커브 찍기
    repeat(n){
        val (y,x,d,g) = br.readLine().split(" ").map { it.toInt() }
        val arr = ArrayList<Int>()
        arr.add(d)
        map[x][y]=1
        var nr = x + dir[d][0]
        var nc = y + dir[d][1]
        map[nr][nc]=1

        repeat(g){
            val stack = Stack<Int>()
            for(i in arr){ stack.add(i)}


            while(stack.isNotEmpty()){
                val plus = (stack.pop()+1)%4
                arr.add(plus)
                nr += dir[plus][0]
                nc += dir[plus][1]

                map[nr][nc]=1
            }
        }
    }
    //꼭지점 세기
    var count =0
    for(i in 0 until map.size-1){
        for(j in 0 until map.size-1){
            var flag = true
            out@ for(k in 0 until 2){
                for(h in 0 until 2){
                    if(map[i+k][j+h]!=1){
                        flag =false
                        break@out
                    }
                }
            }
            if(flag)count++
        }
    }
    println(count)
}