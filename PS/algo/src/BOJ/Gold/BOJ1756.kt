import java.util.*

fun main() {
    val (d,n)= readLine()!!.split(" ").map(String::toInt)
    val oven = readLine()!!.split(" ").map(String::toInt).toMutableList()

    //pizza 에 넣기
    val pizza:Queue<Int> = readLine()!!.split(" ").map(String::toInt).toCollection(LinkedList<Int>())

    //피자 빼기
    var start = oven.lastIndex
    while(pizza.isNotEmpty()){
        val p = pizza.poll()
        var count =1

        while(pizza.isNotEmpty() && p>=pizza.peek()){
            pizza.poll()
            count++
        }
        var flag = true
        for(i in 0 until start ){
            if(p>oven[i]){
                flag = false
                start=i-count
                break
            }
        }
        if(flag) {
            start -= count
        }

        if(start<-1){
            println(0)
            return
        }
    }
    //피자끝
    println(start+1)
}