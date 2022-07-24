fun main(args: Array<String>) {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val arr = readLine()!!.split(" ").map { it.toInt() }.toIntArray()
    val order = LongArray(n)
    val reverseOrder =  LongArray(n)
    var sum1:Long =0
    var sum2:Long =0
    for (i in 0 until order.size-1){
        sum1+= if(arr[i]>arr[i+1])arr[i] - arr[i+1] else 0
        sum2+= if(arr[arr.size-1-i]>arr[arr.size-2-i]) arr[arr.size-1-i] - arr[arr.size-2-i] else 0
        order[i+1]= sum1
        reverseOrder[i+1] = sum2

    }

    val sb = StringBuilder()
    repeat(m){
        val (from,to) = readLine()!!.split(" ").map { it.toInt()-1 }
        if(from<to){
            sb.append(order[to]-order[from]).append("\n")
        }else{
            sb.append(reverseOrder[n-1-to]-reverseOrder[n-1-from]).append("\n")
        }
    }
    println(sb)
}