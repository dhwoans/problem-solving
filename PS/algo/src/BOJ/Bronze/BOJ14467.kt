package BOJ.bronze

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val map = HashMap<Int,Int>()
    var count=0
    repeat(n){
        val (num,pos) = br.readLine().split(" ").map{it.toInt()}

        if(map.containsKey(num)){
            if(map[num]!=pos){
                count++
                map[num] = pos
            }
            else map[num] = pos
        }else{
            map[num] = pos
        }
    }
    println(count)
}