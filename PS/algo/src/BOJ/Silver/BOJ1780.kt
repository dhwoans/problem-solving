package BOJ.Silver

private lateinit var arr:Array<IntArray>
private var count = IntArray(3)
fun main() {
    val n = readln().toInt()
    arr = Array(n){IntArray(n)}.apply{
        repeat(n){
            this[it]=readln().split(" ").map(String::toInt).toIntArray()
        }
    }
    dfs(0,0,n)
    count.forEach{
        println(it)
    }
}

private fun dfs(x:Int,y:Int,size:Int) {
    if(size==1){
        count[arr[x][y]+1]++
        return
    }else{
        val check = arr[x][y]
        var flag = true
        out@for(i in x until x+size){
            for(j in y until y+size){
                    if(arr[i][j]!=check){
                        flag=false
                        break@out
                    }
            }
        }
        if(flag){
            count[check+1]++
        }else{
            dfs(x+size/3,y,size/3)
            dfs(x+2*(size/3),y,size/3)

            dfs(x,y,size/3)
            dfs(x,y+size/3,size/3)
            dfs(x,y+2*(size/3),size/3)

            dfs(x+size/3,y+size/3,size/3)
            dfs(x+2*(size/3),y+2*(size/3),size/3)

            dfs(x+size/3,y+2*(size/3),size/3)
            dfs(x+2*(size/3),y+size/3,size/3)
        }
    }
}