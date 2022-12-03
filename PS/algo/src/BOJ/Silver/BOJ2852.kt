package BOJ.Silver

fun main() {
    val arr = ArrayList<Info>()
    val t = IntArray(2)

    repeat(readln().toInt()) {
        val (team, time) = readln().split(" ")
        val (h, m) = time.split(":").map { it.toInt() }
        arr.add(Info(team.toInt(), h * 60 + m))
    }
    arr.sortedWith(compareBy { it.time })
    val win = intArrayOf(1, arr[0].team-1, arr[0].time)

    for (i in 1 until arr.size) {
        if (win[1] == arr[i].team-1) {  //이기고 있을때
            win[0]++
        } else if (win[1] == -1) {  //무승부
            win[0] = 1
            win[1] = arr[i].team-1
            win[2] = arr[i].time
        } else if (win[1] != arr[i].team-1) {       //득점했을때
            if (--win[0] == 0) {
                t[win[1]] += arr[i].time - win[2]
                win[1] = -1
            }
        }
    }

    if(win[1]!=-1){     //무승부로 끝난게 아니면
        t[win[1]] += 48 * 60 - win[2]
    }
    println("${if (t[0] / 60 < 10) "0" + (t[0] / 60).toString() else t[0] / 60}:${if (t[0] % 60 < 10) "0" + (t[0] % 60).toString() else t[0] % 60}")
    println("${if (t[1] / 60 < 10) "0" + (t[1] / 60).toString() else t[1] / 60}:${if (t[1] % 60 < 10) "0" + (t[1] % 60).toString() else t[1] % 60}")

}

private data class Info(val team: Int, val time: Int)