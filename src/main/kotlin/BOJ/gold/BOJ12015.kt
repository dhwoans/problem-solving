package BOJ.platinum

private lateinit var arr:Array<IntArray>
private lateinit var x:ArrayList<Int>


fun main()= with(System.`in`.bufferedReader()){
    val n = readLine().toInt()
    arr = Array(2){IntArray(n+1)}.apply{
        readLine().split(" ").mapIndexed{index,it->this[0][index+1]=it.toInt()}
    }

    x  = ArrayList<Int>().apply{this.add(0)}

    for(i in 1 until arr[0].size){
        if(arr[0][i]>x[x.lastIndex]){
            x.add(arr[0][i])
        }else{
            val lower = lowerbound(arr[0][i])
            x[lower]  = arr[0][i]
        }
    }
    println(x.lastIndex)

}
private fun lowerbound(num:Int):Int{
    var start = 0
    var end = x.size

    while(start<=end){
        val mid = (start+end)/2

        if(num>x[mid])start = mid+1
        else if(x[mid]==num)return mid
        else end = mid-1
    }
    return start
}