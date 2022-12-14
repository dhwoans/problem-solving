package BOJ.Gold

private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var visited:BooleanArray
private var count =0

fun main() {
    val n = readln().toInt()
    val temp = readln().split(" ").map{it.toInt()}.toIntArray()
    val m = readln().toInt()
    var start =0;
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n){
            this.add(ArrayList<Int>())
        }
        for(i in temp.indices){
            if(temp[i]==-1){
                start=i
                continue
            }
            this[i].add(temp[i])
            this[temp[i]].add(i)
        }
    }
    visited = BooleanArray(n)
    visited[start] = true
    visited[m]=true
    if(start!=m) dfs(start)
    println(count)
}

private fun dfs(node:Int){
    var flag = true
    for(next in arr[node] ){
        if(visited[next])continue
        visited[next]=true
        flag = false
        dfs(next)
    }
    if(flag)count++
}