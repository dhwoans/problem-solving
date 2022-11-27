package BOJ.silver

fun main() {
    val (r, c) = readLine()!!.split(" ").map(String::toInt)
    val arr = Array(r) { CharArray(c) }.apply {
        repeat(r){
            this[it]= readLine()!!.toCharArray()
        }
    }
    //W찾기
    var isPossible = true;
    val dir = Array(4){IntArray(2)}.apply{
        this[0] = intArrayOf(-1,0)
        this[1] = intArrayOf(1,0)
        this[2] = intArrayOf(0,1)
        this[3] = intArrayOf(0,-1)
    }
    for(i in arr.indices){
        for(j in arr[i].indices){
            if(arr[i][j]=='W'){
                for(k in 0 ..3){
                    val nx = i + dir[k][0]
                    val ny = j + dir[k][1]

                    if(nx<0||ny<0||nx>=r||ny>=c)continue;
                    if(arr[nx][ny]=='S')isPossible = false
                }
            }
        }
    }
    if(isPossible){
        println(1)
        arr.forEach { it ->
            it.forEach { i ->
                print(if(i=='.')"D" else i)
            }
            println()
        }
    }else{
        println(0)
    }
}
