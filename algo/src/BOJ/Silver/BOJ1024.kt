package BOJ.silver

fun main() {
    var start =0L
    var turn =0
    val (n,l) = readLine()!!.split(" ").map(String::toLong)
    for(i in l .. 100){
        val t = i*(i-1)/2
        if((n-t)/i>=0&&(n-t)%i==0L){
            start =(n-t)/i
            turn = i.toInt()
            break
        }

    }
    if(turn==0){
        println(-1)
    }else{
        repeat(turn){
            print("$start ")
            start++
        }
    }

}
