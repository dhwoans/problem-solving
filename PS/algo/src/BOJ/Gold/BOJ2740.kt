package BOJ.Gold

fun main() {
    val (r,c)= readln().split(" ").map{it.toInt()}
    val arr1 = Array(r){IntArray(c)}.apply{
        repeat(r){
            this[it] = readln().split(" ").map{it.toInt()}.toIntArray()
        }
    }
    val (a,b) = readln().split(" ").map{it.toInt()}
    val arr2 = Array(a){IntArray(b)}.apply{
        repeat(a){
            this[it] = readln().split(" ").map{it.toInt()}.toIntArray()
        }
    }
    val ans = Array(r){IntArray(b)}

    for(k in 0 until r){
        for(i in 0 until b){
            for(j in 0 until c){
                ans[k][i]+= arr1[k][j] * arr2[j][i]
            }
        }
    }

    for(i in ans){
        for(j in i){
            print("${j} ")
        }
        println()
    }
}