fun main() {
    val (n,m)= readLine()!!.split(" ").map{it.toInt()}
    val arr = IntArray(n).apply{
        repeat(n){
            this[it]=it
        }
    }
    var count =0
    repeat(m){
        val (f,t)=readLine()!!.split(" ").map{it.toInt()-1}
        if(find(f,arr)!=find(t,arr)){
            union(f,t,arr)
        }else{
            count++
        }
    }
    println(count)
}

private fun find(a:Int,arr:IntArray):Int{
    if(arr[a]==a){
        return a
    }
    arr[a]=find(arr[a],arr)
    return arr[a]
}
private fun union(a:Int,b:Int,arr:IntArray){
    val a1 = find(a,arr)
    val b1 = find(b,arr)
    if(a1<b1){
        arr[b1]=a1
    }else{
        arr[a1]=b1
    }
}