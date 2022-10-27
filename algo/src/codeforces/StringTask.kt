package codeforces

fun main() {
    val str = readLine()!!.toString()
    val sb = StringBuilder()
    str.lowercase().forEach{
        if(it=='a'||it=='o'||it=='i'||it=='y'||it=='u'||it=='e')return@forEach
        else sb.append(".").append(it)
    }
    println(sb)
}