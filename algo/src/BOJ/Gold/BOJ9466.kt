package BOJ.gold

private lateinit var arr:IntArray
private lateinit var visited:BooleanArray
private lateinit var check:BooleanArray
private var count =0


fun main() {
    val t  = readLine()!!.toInt()
    repeat(t){
        count =0
        val n = readLine()!!.toInt()
        arr = intArrayOf(0)+readLine()!!.split(" ").map(String::toInt).toIntArray()
        check = BooleanArray(n+1)
        visited = BooleanArray(n+1)


        for(i in 1 .. n){
            if(!visited[i])dfs(i)
        }


        println(n-count)
    }
}

private fun dfs(i:Int){
    if(!visited[i]){
        visited[i]=true
        dfs(arr[i])
    }else{
        if(check[i]) return
        var nextStudent = arr[i]

        while (nextStudent != i){
            count++
            nextStudent = arr[nextStudent]
        }
        count++
        return
    }
    check[i]=true
    return
}