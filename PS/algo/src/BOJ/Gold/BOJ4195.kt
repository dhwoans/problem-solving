package BOJ.Gold

private lateinit var arr:IntArray
private lateinit var size:IntArray
fun main() {
    repeat(readln().toInt()){
        val n = readln().toInt()
        arr =make(n*2)
        size = IntArray(n*2){1}
        val map = HashMap<String,Int>()
        var num =0
        repeat(n){
            val (a,b) = readln().split(" ")
            map[a]= map.computeIfAbsent(a){num++}
            map[b]= map.computeIfAbsent(b){num++}

            val ans = union(map[a]!!,map[b]!!)
            println(ans)
        }
    }
}

private fun make(n:Int):IntArray{
    return IntArray(n).apply{
        repeat(n){
            this[it]=it
        }
    }
}

private fun union(a:Int,b:Int):Int{
    val a1 = find(a)
    val b1 = find(b)

    if(a1!=b1){
       arr[b1]=a1
        size[a1]+=size[b1]
    }
    return size[a1]
}

private fun find(a:Int):Int{
    if(a == arr[a]){
        return a
    }
    arr[a]=find(arr[a])
    return arr[a]
}