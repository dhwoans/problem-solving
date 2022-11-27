package BOJ.gold

import java.util.LinkedList
import java.util.Queue
import kotlin.math.max
import kotlin.math.pow


private lateinit var map:Array<IntArray>
private lateinit var visited:Array<BooleanArray>
private var ice=0
private var size=0

private val  dir = Array(4){ IntArray(2) }.apply {
    this[0]= intArrayOf(-1,0)
    this[1]= intArrayOf(1,0)
    this[2]= intArrayOf(0,-1)
    this[3]= intArrayOf(0,1)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,q) = br.readLine().split(" ").map{it.toInt()}
    map = Array((2.0).pow(n).toInt()){IntArray((2.0).pow(n).toInt())}
    repeat(map.size){map[it]= br.readLine().split(" ").map { it.toInt() }.toIntArray()}
    visited = Array((2.0).pow(n).toInt()){BooleanArray((2.0).pow(n).toInt())}
    val level = br.readLine().split(" ").map { it.toInt() }.toIntArray()

    repeat(q){
        div((2.0).pow(n).toInt(),(2.0).pow(level[it]).toInt(),0,0)
        melt()
    }

    for(i in 0 until map.size){
        for(j in 0 until map.size){
            if(!visited[i][j]&&map[i][j]!=0) {
                ice+=map[i][j]
                ice(i,j)
            }
        }
    }
    println(ice)
    println(size)
}

fun div(n:Int,level:Int,r:Int,c:Int){
    if(n==level){
        turn(n,r,c)
    }else{
        div(n/2,level,r,c)
        div(n/2,level,r+n/2,c)
        div(n/2,level,r,c+n/2)
        div(n/2,level,r+n/2,c+n/2)
    }
}
fun turn(n:Int,r:Int,c:Int){
    //복사
    val temp = Array(n){IntArray(n)}
    for(i in 0 until temp.size){
        for(j in 0 until temp.size){
            temp[i][j]=map[r+i][c+j]
        }
    }
    //바꾸기
    for(i in 0 until n){
        for(j in 0 until n){
            map[r+j][c+n-1-i]=temp[i][j]
        }
    }

}

fun melt(){
    val melt = ArrayList<IntArray>()
    for(i in 0 until map.size){
        for ( j in 0 until map[0].size){
            if(checkMelt(i,j)){
                if(map[i][j]!=0) {
                    melt.add(intArrayOf(i,j))
                }
            }
        }
    }
    melt.forEach{if(map[it[0]][it[1]]!=0)map[it[0]][it[1]]-=1}
}

fun checkMelt(r:Int,c:Int):Boolean {
    var count = 0
    for(i in 0 until 4){
        val nr = r + dir[i][0]
        val nc = c + dir[i][1]

        if(nr<0||nc<0||nr>=map.size||nc>=map[0].size)continue
        if(map[nr][nc]!=0)count++
    }
   return count<3
}

fun ice(r:Int,c:Int){
    var countSize=1;
    visited[r][c]=true
    val que:Queue<IntArray> = LinkedList()
    que.add(intArrayOf(r,c))
    while(que.isNotEmpty()){
        val temp = que.poll()

        for(i in 0 until 4){
            val nr = temp[0]+dir[i][0]
            val nc = temp[1]+dir[i][1]

            if(nr<0||nc<0||nr>=map.size||nc>=map[0].size)continue
            if(map[nr][nc]!=0&& !visited[nr][nc]){
                ice+=map[nr][nc]
                countSize++
                visited[nr][nc]=true
                que.add(intArrayOf(nr,nc))
            }
        }
    }
    size = max(size,countSize)
}