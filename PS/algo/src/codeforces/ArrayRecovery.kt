package codeforces

fun main() {
    val t = readLine()!!.toInt()
    repeat(t){
        val n = readLine()!!.toInt()
        val a = IntArray(n)
        val d = readLine()!!.split(" ").map(String::toInt).toIntArray()
        var flag = false
        a[0]=d[0]
        for(i in 1 until n){
            if(d[i]!=0&&a[i-1]>=d[i]){
                flag = true
                println(-1)
                break;
            }
            a[i]=d[i]+a[i-1]
        }
        if(!flag){
            a.forEach {
                print("${it} ")
            }
            println()
        }
    }
}