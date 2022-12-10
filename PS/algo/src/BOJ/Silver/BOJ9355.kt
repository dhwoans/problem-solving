package BOJ.Silver

import java.lang.Integer.min


private lateinit var arr:ArrayList<ArrayList<Int>>
private var min:Int = 0

fun main() {
    repeat(readln().toInt()){
        val n = readln().toInt()
        //인접 리스트
        arr = ArrayList<ArrayList<Int>>().apply{
            repeat(n){
                this.add(ArrayList<Int>())
            }
            repeat(n){
                val temp = readln().split(" ").map{it.toInt()}.toIntArray()
                repeat(temp[0]){ m ->
                    this[it].add(temp[m+1]-1)
                }
            }
        }
        min = Int.MAX_VALUE
        for(i in 0 until n ){
            dfs(i,1,0,n)
        }
        println(min)
    }
}

private fun dfs(num: Int,count:Int,bit:Int,n:Int) {
    var temp = bit
    temp =temp or (1 shl num)
    for(i in arr[num]){
        temp = temp or(1 shl i)
    }
    if(temp == (1 shl n)-1){
        min = min(min,count)
        return
    }else{
        for(i in 0 until n){
            if(temp and (1 shl i) ==0){
               dfs(i,count+1,temp,n)
            }
        }
    }
}