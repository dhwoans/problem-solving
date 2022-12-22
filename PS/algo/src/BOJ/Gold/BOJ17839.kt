package BOJ.Gold

private lateinit var arr:ArrayList<ArrayList<Int>>
private val map = HashMap<String,Int>()
private val ans = ArrayList<String>()
private val word = HashMap<Int,String>()
private lateinit var visited:BooleanArray
fun main() {

    var num = 0
    val n = readln().toInt()
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(2*n){
            this.add(ArrayList<Int>())
        }
    }
    repeat(n) {
        val (from, to) = readln().split(" is ")
        val f = map.computeIfAbsent(from){num++}
        val t = map.computeIfAbsent(to){num++}

        word[f] = from
        word[t] = to

        arr[f].add(t)
        arr[t].add(t)
    }
    val start = map["Baba"]
    if(start!=null){
        visited = BooleanArray(arr.size)
        visited[start] = true
        dfs(start);
        ans.sort()
        ans.forEach { println(it) }

    }
}
private fun dfs(next:Int){
    for(i in arr[next]){
        if(visited[i])continue
        visited[i]=true
        ans.add(word[i]!!)
        dfs(i)
    }
}