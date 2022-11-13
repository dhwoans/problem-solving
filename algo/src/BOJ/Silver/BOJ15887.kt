package BOJ.Silver

import java.util.*

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toIntArray()
    val check = IntArray(n).mapIndexed{index, i -> index+1 }
    val op = ArrayList<Pair<Int,Int>>()
    var count =0
    while(count<arr.size){
        if(check[count]==arr[count]){
            count++
        }else{
            for(i in count until arr.size){
                if(arr[i]==count+1){
                    op.add(Pair(count+1,i+1))
                    var start = count
                    var end = i

                    while(start<end){
                        val temp = arr[start]
                        arr[start] = arr[end]
                        arr[end]= temp
                        start++
                        end--
                    }
                    break;
                }
            }
            count++
        }
    }
    println(op.size)
    op.forEach {
        println("${it.first} ${it.second}")
    }

}
