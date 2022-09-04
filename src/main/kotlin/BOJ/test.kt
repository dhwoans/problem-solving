import java.util.*
import kotlin.math.abs

fun main() {
    val t = readLine()!!.toInt()
    repeat(t) {
        val n = readLine()!!.toLong()
        val que = PriorityQueue<Long>(reverseOrder())


        val arr = IntArray(2)
        var sum:Long =0
        val str = readLine()!!.toString()

        str.forEachIndexed{ index,it ->
            if(it=='R'){
                sum+= n-1-index
                arr[0]++
            } else {
                sum+= index
                arr[1]++
            }
        }

        //위치비교
        var r = 'R'
        var count =-1
        for(i in str){
            count++
            if(count>(n/2L)-1) r ='L'
            if(r!=i){
                que.add(abs(count-(n-1-count)))
            }
        }
        //꺼내기
        for(i in 0 until n){
            if(que.isNotEmpty()){
                sum+=que.poll()
                print("$sum ")
            }else
                print("$sum ")
        }
        println()
    }
}