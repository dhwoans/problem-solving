package BOJ.Silver

fun main() {
    repeat(readln().toInt()){
        val map = HashMap<String,Int>()
        val n = readln().toInt()
        var count =0
        readln().split(" ").forEach {
            map[it]=count++
        }
        val ans = Array<String>(n){""}
        val num = readln().split(" ").toTypedArray()
        readln().split(" ").forEachIndexed{ index,v->
            ans[map[num[index]]!!]=v
        }
        ans.forEach {
            print("${it} ")
        }
    }


}