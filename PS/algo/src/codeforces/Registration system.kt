package codeforces

fun main() {
    val map = HashMap<String,Int>();
    val n = readLine()!!.toInt();
    val sb = StringBuilder();
    repeat(n){
        val name = readLine()!!
        if(map.containsKey(name)){
            sb.appendLine("$name${map[name]}")
            map[name]=map[name]!!+1
        }else{
            sb.appendLine("OK")
            map[name] = 1
        }
    }
    println(sb)
}