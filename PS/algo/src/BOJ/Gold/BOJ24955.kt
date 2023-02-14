package BOJ.Gold
private lateinit var arr:ArrayList<ArrayList<Int>>
private lateinit var visited:BooleanArray
private lateinit var nums:LongArray
private var sb = StringBuilder()
private const val mod = 1_000_000_007
private var path = IntArray(1_001)
private var end= 0
private var flag = true
fun main() {
    val (n,m)=readln().split(" ").map{it.toInt()}
    nums = readln().split(" ").map{it.toLong()}.toLongArray()
    arr = ArrayList<ArrayList<Int>>().apply{
        repeat(n){
            this.add(ArrayList())
        }
        repeat(n-1){
            val(f,t)=readln().split(" ").map{it.toInt()-1}
            this[f].add(t)
            this[t].add(f)
        }
    }
    repeat(m){
        sb= StringBuilder()
        visited = BooleanArray(n)
        end= 0
        path =IntArray(1_001)
        flag= true
        val (f,t)=readln().split(" ").map{it.toInt()-1}
        visited[f]=true
        path[0]=f
        dfs(f,t,1)
        for(i in 0 until end){
            sb.append(nums[path[i]])
        }
        println(sb.toString().toBigInteger().mod(mod.toBigInteger()))
    }
}
private fun dfs(next:Int,target:Int,cnt:Int) {
    if(next==target){
        end = cnt
        flag = false
        return
    }else{
        for(i in arr[next]){
            if(visited[i])continue
            visited[i]=true
            if(flag)path[cnt]=i
            dfs(i,target,cnt+1)
        }
    }
}