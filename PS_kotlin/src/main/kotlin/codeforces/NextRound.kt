fun main(){
    var n = readLine()!!.toString()
    var count =0
    while(true){
        if(n.length==1)break
        count++
        val sum = n.fold(0) { total, next -> total + (next-'0') }.toString()
        n = sum
    }
    println(count)
}
