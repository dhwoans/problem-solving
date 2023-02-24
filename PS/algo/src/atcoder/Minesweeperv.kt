package atcoder

fun main() {
    val (n,m) = readLine()!!.split(" ").map{it.toInt()}
    val arr = Array(n){CharArray(m)}.apply{
        repeat(n){
            this[it]= readLine()!!.toCharArray()
        }
    }
    val dir = Array(8){IntArray(2)}.apply{
        this[0]= intArrayOf(-1,0)
        this[1]= intArrayOf(0,-1)
        this[2]= intArrayOf(1,0)
        this[3]= intArrayOf(0,1)
        this[4]= intArrayOf(-1,1)
        this[5]= intArrayOf(1,-1)
        this[6]= intArrayOf(1,1)
        this[7]= intArrayOf(-1,-1)
    }
    for(i in 0 until n){
        for(j in 0 until m){
            if(arr[i][j]=='.'){
                var count =0
                //check dir
                for(k in dir){
                    val nx = i + k[0]
                    val ny = j + k[1]

                    if(nx <0||ny<0||nx>=n ||ny>=m)continue
                   if(arr[nx][ny]=='#')count++
                }
                arr[i][j]= Character.forDigit(count, 10)
            }
        }
    }
    for(i in arr){
        for(j in i){
            print(j)
        }
        println()
    }
}