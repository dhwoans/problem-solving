package BOJ.Gold

import java.util.*

fun main() {
    val que = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    val computer = PriorityQueue<computerInfo>(compareBy { it.end })
    val  q = PriorityQueue<computerInfo>(compareBy { it.num})
    val ans = IntArray(100_001){1}
    //시작시작 빠른 순으로
    repeat(readln().toInt()) {
        val (f, t) = readln().split(" ").map { it.toInt() }
        que.add(Pair(f, t))
    }
    var count =0
    while(que.isNotEmpty()){
        val temp = que.poll()
        if(computer.isEmpty()){
            computer.add(computerInfo(temp.second,count++))
        } else {     // 갱신
            while(computer.isNotEmpty()&&computer.peek().end<=temp.first){
                q.add(computer.poll())
            }
            if(q.isEmpty()){
                computer.add(computerInfo(temp.second,count++))
            }else{
                val c = q.poll()
                ans[c.num]++
                computer.add(computerInfo(temp.second, c.num))

            }
        }
    }

    println(count)
    for(i in 0 until count){
        print("${ans[i]} ")
    }
}

/**
 * end  : 종료시간
 * num  : 자리번호
 */
private data class computerInfo(var end:Int, var num:Int)