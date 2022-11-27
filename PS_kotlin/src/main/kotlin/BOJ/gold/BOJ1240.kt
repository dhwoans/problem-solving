package BOJ.gold

fun main() {
    val (n,m) = readLine()!!.split(" ").map(String::toInt)
    val sb = StringBuilder()
    val arr = Array(n){IntArray(n){9876554} }

    //간선정보
    repeat(n-1){
        val(from,to,dis) = readLine()!!.split(" ").map(String::toInt)
        arr[from-1][to-1]=dis
        arr[to-1][from-1]=dis
    }

    //플로이드-워샬
    for(k in 0 until n){
        for(i in 0 until n){
            for(j in 0 until n){
                if(arr[i][j]>arr[i][k]+arr[k][j])arr[i][j]=arr[i][k]+arr[k][j]
            }
        }
    }

    //거리가 알고 싶은 두노드
    repeat(m){
        val(a,b) = readLine()!!.split(" ").map(String::toInt)
        sb.appendLine(arr[a-1][b-1])
    }
    println(sb)
}