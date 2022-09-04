package BOJ.silver

import java.io.BufferedReader
import java.util.StringTokenizer

fun main() =with(BufferedReader(System.`in`.bufferedReader())){
    val n = readLine().toInt()
    val sb =StringBuilder()
    val arr = ArrayList<Int>()
    repeat(n){
        val st = StringTokenizer(readLine())
        val command = st.nextToken()
        when(command){
            "push_front" -> arr.add(0,st.nextToken().toInt())
            "push_back" -> arr.add(st.nextToken().toInt())
            "pop_front" -> {
                if(arr.size!=0){
                    sb.append(arr[0]).append("\n")
                    arr.removeAt(0)
                } else sb.append(-1).append("\n")

            }
            "pop_back" -> {
                if(arr.size!=0){
                    sb.append(arr[arr.size-1]).append("\n")
                    arr.removeAt(arr.size-1)
                }
                else sb.append(-1).append("\n")
            }
            "size" ->  sb.append(arr.size).append("\n")
            "empty" -> if(arr.size==0)sb.append(1).append("\n")
                        else sb.append(0).append("\n")
            "front" -> if(arr.size==0)sb.append(-1).append("\n")
                        else sb.append(arr[0]).append("\n")
            "back" -> if(arr.size==0)sb.append(-1).append("\n")
                        else sb.append(arr[arr.size-1]).append("\n")
        }
    }
    println(sb)
}