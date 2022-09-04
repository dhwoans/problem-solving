package BOJ.silver

import java.util.*

fun main() {
    val map = TreeMap<String,Double>()
    val sc = Scanner(System.`in`)
    var count=0.0

    while(sc.hasNextLine()){
        count++
        val str = sc.nextLine()
        map[str] = map.getOrDefault(str,0.0)+1.0
    }
    for(i in map){
        println("${i.key} ${String.format("%.4f",(i.value*100).div(count))}")
    }
}