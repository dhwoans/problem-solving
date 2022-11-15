package BOJ.gold

fun main() {
    val day = IntArray(10_001)
    val arr = ArrayList<Lecture>()
    repeat(readln().toInt()){
        val (bill,day)= readln().split(" ").map(String::toInt)
        arr.add(Lecture(day-1,bill))
    }
    //정렬
    arr.sortWith(compareBy({it.day},{-it.bill}))
    for(i in arr){
        if(day[i.day]==0){
            day[i.day]=i.bill
        }else{
            var min = i.bill
            var pos =0
            var flag = false
            for(j in i.day downTo 0){//최소값찾기
                if(day[j]<min){
                    flag = true
                    min = day[j]
                    pos =j
                }
            }
            if(flag){
                day[pos]=day[i.day]
                day[i.day]=i.bill
            }
        }
    }
    println(day.sum())
}private data class Lecture (val day:Int ,val bill:Int)