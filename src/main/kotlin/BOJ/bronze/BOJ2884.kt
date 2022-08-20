package BOJ.bronze

fun main() {
    var (hour,min) = readLine()!!.split(" ").map(String::toInt)
    if(min<45){
        if(hour==0){hour=24}
        hour-=1
        min +=15
    }else{
        min-=45
    }
    println("$hour $min")
}