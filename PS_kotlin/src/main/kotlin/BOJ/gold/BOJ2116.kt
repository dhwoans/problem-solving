package BOJ.gold

import kotlin.math.max


fun main() {
    val n = readLine()!!.toInt()
    val arr = Array(n){IntArray(6)}.apply{
        repeat(n){
            this[it]= readLine()!!.split(" ").map(String::toInt).toIntArray()
        }
    }
    var answer = 0

    for(k in 0 until arr[0].size){
        var down = k
        var up = arr[0][up(k)]
        var max = arr[0].filterIndexed { index, _ -> index!= down && index!=up(down) }.maxOrNull() ?: -100


        for(i in 1 until arr.size){
            //밑,위 찾기
            for(j in 0 until arr[i].size){
                if(arr[i][j]==up){
                    down = j
                    up = arr[i][up(j)]
                    break
                }
            }
            //최대 값 계산
            max += arr[i].filterIndexed { index, _ -> index!=down && index!=up(down) }.maxOrNull() ?: -100
        }
        answer = max(answer,max)
    }
    println(answer)
}

private fun up(selectedIndex:Int):Int{
    val dice = intArrayOf(5,3,4,1,2,0)
    return dice[selectedIndex]
}