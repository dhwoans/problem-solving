package codeforces

fun main() {
    repeat(readLine()!!.toInt()){
        val n = readLine()!!.toInt()
        val a = readLine()!!.split(" ").map(String::toLong)
        val b = readLine()!!.split(" ").map(String::toLong)

        println(a.sum()+b.sum()- b.maxOrNull()!!)

    }
}