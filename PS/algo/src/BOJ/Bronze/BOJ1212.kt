package BOJ.bronze


fun main() {
    val str = readln()
    val sb = StringBuilder()

    str.forEachIndexed{ index,it->
        val temp = (it-'0').toString(2)
        if(index==0){
            sb.append(temp)
        }else{
            sb.append("0".repeat(3-temp.length)).append(temp)
        }
    }
    println(sb)
}

