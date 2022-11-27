package BOJ.Gold


private lateinit var arr: Array<BooleanArray>
fun main() {
    val sb = StringBuilder()
    val n = readln().toInt()
    arr = Array(n) { BooleanArray(2 * n - 1) }
    //가운데 왼쪽 오른쪽
    make(0, (arr[0].size) / 2,n)
    //출력
    for (element in arr) {
        for (j in element) {
            if (j) sb.append("*")
            else sb.append(" ")
        }
        sb.append("\n")
    }
    println(sb)
}

private fun make(x: Int, y: Int,depth:Int) {
   if(depth==3){
       arr[x][y]=true

       arr[x+1][y+1]=true
       arr[x+1][y-1]=true

       arr[x+2][y-2]=true
       arr[x+2][y+2]=true
       arr[x+2][y-1]=true
       arr[x+2][y+1]=true
       arr[x+2][y]=true
   }else{
       make(x, y,depth/2)
       make(x+depth/2,y+depth/2,depth/2)
       make(x+depth/2,y-depth/2,depth/2)
   }
}