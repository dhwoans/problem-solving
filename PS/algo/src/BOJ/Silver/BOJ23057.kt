package BOJ.Silver
private val set=HashSet<Int>()

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map{it.toInt()}.toIntArray()
    dfs(arr,0,0)
    println(arr.sum()-set.size+1)
}
private fun dfs(arr:IntArray,cnt:Int,sum:Int){
    set.add(sum)
    if(cnt==arr.size){
        return
    }
    dfs(arr,cnt+1,sum)
    dfs(arr,cnt+1,sum+arr[cnt])
}