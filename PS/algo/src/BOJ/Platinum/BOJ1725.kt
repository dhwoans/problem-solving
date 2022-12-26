package BOJ.Platinum

import kotlin.math.min

private lateinit var arr:IntArray
private lateinit var tree:IntArray

fun main() {
    val (n,m) = readln().split(" ").map{it.toInt()}
    arr = IntArray(n).apply{
        repeat(n){
            this[it]=readln().toInt()
        }
    }
    tree = IntArray(n*4)
    build(0,n-1,1)
    repeat(m){
        val (left,right) = readln().split(" ").map{it.toInt()-1}
        val ans = query(0,n-1,1,left,right)
        println(ans)

    }

}
private fun build(s:Int,e:Int,node:Int){
    if(s==e){
        tree[node]=arr[s]
        return
    }
    val mid = (s+e)/2
    build(s,mid,node*2)
    build(mid+1,e,node*2+1)
    tree[node]= min(tree[node*2],tree[node*2+1])
    return
}
private fun query(s:Int,e:Int,node:Int,l:Int,r:Int):Int{
    //범위 안
    if(l<=s && e <= r){
        return tree[node]
    }
    //범위 밖
    if(r<s || e<l){
        return Int.MAX_VALUE
    }
    val mid = (s + e)/2
    val left = query(s,mid,node*2,l,r)
    val right = query(mid+1,e,node*2+1,l,r)
    return min(left,right)
}
