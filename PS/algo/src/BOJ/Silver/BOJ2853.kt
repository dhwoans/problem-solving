package BOJ.Silver

fun main() {
    val n = readln().toInt()
    val arr = IntArray(n).apply {
        repeat(n) {
            this[it] = readln().toInt()-1
        }
    }
    var count =0
   for(i in 1 until arr.size){
       if(arr[i]==0)continue
       else count++
       for(j in i+1 until arr.size){
           if(arr[j]%arr[i]==0)arr[j]=0
       }
   }
    println(count)
}