package BOJ.Silver

import kotlin.math.max
import kotlin.math.min

private var count =0
private var target=0
private var flag = true
fun main() {
    val (n,k) = readln().split(" ").map{it.toInt()}
    val arr =intArrayOf(0)+readln().split(" ").map{it.toInt()}.toIntArray()
    target=k
    buildMinHeap(arr,n)

    for (i in n downTo 2) {
        //swap
        count++
        if(count==target){
            println("${min(arr[1],arr[i])} ${max(arr[1],arr[i])}")
            flag= false
        }
        val temp = arr[1]
        arr[1]=arr[i]
        arr[i]=temp

        heapify(arr, 1, i-1);
    }
    if(flag) println(-1)
}
private fun buildMinHeap(arr:IntArray,n:Int){
    for (i in n/2 downTo 1){
        heapify(arr, i, n)
    }
}
private fun heapify(arr:IntArray,k:Int,n:Int){

    val left = 2*k
    val right =2*k+1
    var min = 0
    if(right<= n) {
        min = if (arr[left] < arr[right]) left else right
    } else if(left<=n) min = left;
    else return;

    // 최소 힙 성질을 만족하지 못하는 경우 재귀적으로 수정한다.
    if (arr[min] < arr[k]){
        //swap
        count++
        if(count==target){
            println("${min(arr[min],arr[k])} ${max(arr[min],arr[k])}")
            flag= false
        }
        val temp = arr[k]
        arr[k]=arr[min]
        arr[min]=temp

        heapify(arr, min, n);
    }

}
