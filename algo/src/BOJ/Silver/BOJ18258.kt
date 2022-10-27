package BOJ.silver

import java.io.BufferedReader
import java.util.StringTokenizer

fun main() = with(BufferedReader(System.`in`.bufferedReader())){
    val arr = ArrayList<Int>()
    val n = readLine().toInt()
    val sb = StringBuilder()
    var pointer =0
    repeat(n){
        val st = StringTokenizer(readLine())
        val command = st.nextToken().toString()
        when(command) {
            "push" -> arr.add(st.nextToken().toString().toInt())
            "pop" -> {
                if(arr.size-pointer==0){
                    sb.append(-1).append("\n")
                }else{
                    sb.append(arr[pointer++]).append("\n")

                }
            }
            "size" -> sb.append(arr.size-pointer).append("\n")
            "empty" ->{
                if(arr.size-pointer==0){
                    sb.append(1).append("\n")
                }else{
                    sb.append(0).append("\n")
                }
            }
            "front"->{
                if(arr.size-pointer==0){
                    sb.append(-1).append("\n")
                }else
                    sb.append(arr[pointer]).append("\n")
            }
            "back"->{
                if(arr.size-pointer==0){
                    sb.append(-1).append("\n")
                }else{
                    sb.append(arr[arr.size-1]).append("\n")
                }
            }
            else -> return@with
        }
    }
    println(sb)
}