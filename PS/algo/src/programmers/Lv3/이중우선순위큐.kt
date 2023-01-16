package programmers.Lv3

import java.util.*

class Solution {
    fun solution(operations: Array<String>): IntArray {
        val map = HashMap<Int, Int>()
        val min = PriorityQueue<Int>()
        val max = PriorityQueue<Int>(Collections.reverseOrder())
        for (i in operations) {
            val (a, n) = i.split(" ")
            when (a) {
                "I" -> {
                    min.add(n.toInt())
                    max.add(n.toInt())
                }
                "D" -> {
                    if (n.toInt() == 1&&max.isNotEmpty()) {
                        map[max.poll()]=1
                    } else if (n.toInt() == -1&&max.isNotEmpty()) {
                        map[min.poll()]=1
                    }
                    //정리
                    while (true) {
                        if (max.size == 0) break
                        if (map.containsKey(max.peek())) {
                            max.poll()
                        } else {
                            break
                        }
                    }
                    while (true) {
                        if (min.size == 0) break
                        if (map.containsKey(min.peek())) {
                            min.poll()
                        } else {
                            break
                        }
                    }
                }
            }
        }
        if (max.size == 0) {
            return intArrayOf(0, 0)
        }

        return intArrayOf(max.poll(), min.poll())
    }
}