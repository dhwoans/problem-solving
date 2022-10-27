package BOJ.gold

private lateinit var x:ArrayList<Int>
fun main() {
    val n = readLine()!!.toInt()
    x = ArrayList<Int>().apply{this.add(0)}
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()

    arr.forEach{
        if(x.last()<it)x.add(it)
        else{
            val index = lis(it)
            x[index]=it
        }
    }
    println(n-x.lastIndex)
}

private fun lis(target:Int):Int{
    var start = 0
    var end = x.lastIndex
    while(start<=end){
       val mid = (start + end)/2
        if(x[mid]==target)return mid
        if(x[mid]<target) start = mid +1
        else end = mid -1
    }
    return start
}
