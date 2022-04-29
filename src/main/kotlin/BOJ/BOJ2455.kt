import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    var max = 0
    var persons = 0
    var count=0

    while(count++<4) {
        val (inn, out) = readLine().split(" ").map { it.toInt() }
        persons += (out - inn)
        if (max < persons) max = persons
    }
    println(max)
}

