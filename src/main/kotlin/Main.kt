import kotlin.math.abs

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    repeat(t) {
        val str = readLine()!!.toString()
        val sb =StringBuilder()
        val arr = Array(str.length) { IntArray(2) }.apply {
            repeat(str.length) {
                this[it] = intArrayOf(it, str[it].code - 'a'.code + 1)
            }
//            this.sortBy { it[1] }
            this.sortWith(compareBy ({it[1] },{it[0]}))
        }
        var index = arr.size
        var sum = 0
        var flag = false
        for(i in 0 until arr.size){
            if(i!=0&&arr[i][0]==0){
                flag = true
                index = i+1
                break
            }
            if(i==arr.size-1)continue
            sum += abs(arr[i][1]-arr[i+1][1])
            sb.append(arr[i][0]+1).append(" ")
        }
        if(flag){
            sb.append(1).reverse()
        }else{
            sb.append(arr[arr.size-1][0]+1)
        }
        println("${sum} ${index}")
        println(sb)

    }
}