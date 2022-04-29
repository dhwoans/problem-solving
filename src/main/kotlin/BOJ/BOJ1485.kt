import kotlin.math.pow

class xy(val x:Int, val y:Int)

fun main()= with(System.`in`.bufferedReader()){
    var arr = mutableListOf<Int>()
    repeat(readLine()!!.toInt()){
        val xxyy = mutableListOf<xy>()
        //좌표 넣기
        repeat(4){
            val (x,y) = readLine().split(" ").map{it.toInt()}
            xxyy.add(xy(x,y))
        }
        //거리 계산하기
        val cal = mutableListOf<Int>()
        for (i in 0 until xxyy.size){
            for (j in i+1 until xxyy.size){
                cal.add(distance(xxyy.get(i),xxyy.get(j)))
            }
        }
        //거리 확인
        cal.sort()
        if(cal[0]==cal[1]&&cal[1]==cal[2]&&cal[2]==cal[3]&&cal[4]==cal[5]){
            println(1)
        }else{
            println(0)
        }
    }
}

private fun distance(xy1:xy, xy2:xy): Int {
   return ((xy1.x-xy2.x).toDouble().pow(2)+(xy1.y-xy2.y).toDouble().pow(2)).toInt()
}
