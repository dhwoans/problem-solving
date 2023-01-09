import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashSet

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val arr = ArrayList<HashSet<Int>>()
        repeat(n) { s ->
            val temp = HashSet<Int>()
            temp.add(s)
            readln().split(" ").map { it.toInt() - 1 }.forEachIndexed { index, i ->
                if (index == 0) {
                    return@forEachIndexed
                } else {
                    temp.add(i)
                }
            }
            arr.add(temp)
        }
        var count = 0
        while (true) {
            if(arr.size==0)break
            arr.sortWith(compareBy { -it.size })
            if (arr[0].isEmpty()) break
            count++
            for (i in 1 until arr.size) {
                for (j in arr[0]) {
                    if (arr[i].contains(j)) arr[i].remove(j)
                }

            }

            arr.removeAt(0)
        }
        println(count)
    }
}