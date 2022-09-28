package BOJ.silver

fun main() {
    val n = readLine()!!.toInt()
    val layer = IntArray(10_000_001)
    var count =0L
    var computer =0L
    repeat(n){
        val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()
        for(i in arr){
            if(i==0)continue
            count++
            layer[i]++
            computer+=i
        }
    }
    var acc = 0L
    val half: Long = if(computer%2==0L) computer shr 1 else (computer shr 1) +1
    for(i in layer.indices){
        if(acc >= half){
            println(i)
            return
        }
        count -= layer[i]
        acc += count
    }
}