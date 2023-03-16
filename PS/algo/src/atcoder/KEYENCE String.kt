package atcoder

fun main() {
    val s = readLine()!!.toString()
    for (i in s.indices) {
        for(j in i until s.length ){
            val check =s.substring(0,i)+s.substring(j,s.length)
            if(check=="keyence"){
                println("YES")
                return
            }
        }
    }
    println("NO")
}