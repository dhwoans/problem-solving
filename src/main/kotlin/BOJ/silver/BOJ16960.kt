package BOJ.silver


fun main() {
    val (n,m)= readLine()!!.split(" ").map(String::toInt)
    val count = IntArray(m+1)
    val infos = ArrayList<IntArray>()
    //정보저장
    repeat(n){
        val info = readLine()!!.split(" ").map(String::toInt).toIntArray()
        infos.add(info.copyOfRange(1,info.size))

        repeat(info[0]){
            count[info[it+1]]++
        }
    }
    //하나씩 빼기
    var flag = false
    for(i in infos){
        val check  = count.copyOf()
        for(j in i ){
            check[j]--
        }
        //세어보기
        for(j in 1 until check.size){
            if(check[j]<=0){
                flag = false
                break
            }else{
                flag = true
            }
        }
        if(flag){
            println(1)
            return
        }
    }
    println(0)
}