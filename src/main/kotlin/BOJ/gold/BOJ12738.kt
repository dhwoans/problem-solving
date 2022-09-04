

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val arr  = br.readLine().split(" ").map{it.toInt()}.toIntArray()
    val x= ArrayList<Int>().apply{this.add(Int.MIN_VALUE)}
    //LIS
    arr.forEach {
        if(x[x.lastIndex]<it){
            x.add(it)
        }else {
            val i = lowerbound(x,it)
            x[i] = it
        }
    }
    println(x.lastIndex)

}

fun lowerbound(arr:ArrayList<Int>,target:Int):Int{
    var start =0
    var end = arr.lastIndex
    while(start<=end){
        val mid = (start+end) / 2
        if(arr[mid]==target)return mid
        else if(arr[mid]<target) start = mid +1
        else end = mid -1
    }
    return start
}