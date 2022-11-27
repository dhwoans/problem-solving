package BOJ.gold


fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val str = br.readLine().split(" ").map{ it.toInt() }.toIntArray()
    val map = Array(n) {IntArray(n) {0} }

    val turn = br.readLine().toInt()
    //펠린드롬 확인
    for(i in 0 until n){
        map[i][i]=1
    }

    for(i in 0 until n-1){
        if(str[i]==str[i+1])map[i][i+1]=1
    }

    for(i in  2 until n){
        for(j in 0 until n-i){
            if(str[j]==str[j+i]&&map[j+1][j+i-1]==1)map[j][j+i]=1
        }
    }

    val sb = StringBuilder()
    repeat(turn) {
        val (s, e) = br.readLine().split(" ").map { it.toInt() }
        sb.appendLine(map[s-1][e-1])
    }
    println(sb)
}