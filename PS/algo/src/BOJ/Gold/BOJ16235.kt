package BOJ.gold


import java.util.*

private val dir =Array(8){IntArray(2)}.apply {
    this[0]= intArrayOf(-1,-1)
    this[1]= intArrayOf(-1,0)
    this[2]= intArrayOf(-1,1)
    this[3]= intArrayOf(0,-1)
    this[4]= intArrayOf(0,1)
    this[5]= intArrayOf(1,-1)
    this[6]= intArrayOf(1,0)
    this[7]= intArrayOf(1,1)
}

fun main() {
    val br = System.`in`.bufferedReader()
    val (n,m,k) = br.readLine().split(" ").map{it.toInt()}
    val map = Array(n){IntArray(n){5}}
    var que = PriorityQueue<Tree>()
    //추기양분
    val energy = Array(n){IntArray(n)}.apply {
        repeat(n){
            this[it]=br.readLine().split(" ").map { it.toInt() }.toIntArray()
        }
    }
    //나무
    repeat(m){
        val (r,c,age) = br.readLine().split(" ").map { it.toInt() }
        que.add(Tree(r-1,c-1,age))
    }

    repeat(k){
        //봄
        val alive = PriorityQueue<Tree>()
        val dead:Queue<Tree> = LinkedList()
        while(que.isNotEmpty()) {
            val i = que.poll()
            if(map[i.r][i.c]>=i.age){
                map[i.r][i.c]-=i.age
                i.age++
                alive.add(i)
            }else{
                dead.add(i)
            }
        }
        //여름
        while(dead.isNotEmpty()){
            val tree = dead.poll()
            map[tree.r][tree.c]+=tree.age/2
        }
        //가을
        val temp = PriorityQueue<Tree>(alive)
        while(alive.isNotEmpty()){
            val t = alive.poll()
            if(t.age%5==0) {

                for (i in dir) {
                    val nx = t.r + i[0]
                    val ny = t.c + i[1]
                    if (nx < 0 || ny < 0 || nx >= n || ny >= n) continue
                    temp.add(Tree(nx, ny, 1))
                }
            }
        }
        que = temp
        //겨울
        for(i in 0 until n){
            for( j in 0 until n){
                map[i][j]+=energy[i][j]
            }
        }
    }
    println(que.size)
}

private data class Tree(val r:Int, val c:Int, var age:Int):Comparable<Tree>{
    override fun compareTo(other: Tree): Int {
        return age-other.age
    }

}