package codeforces

fun main() {
    val n = readLine()!!.toInt()
    val odd = ArrayList<Int>()
    val even = ArrayList<Int>()
    readLine()!!.split(" ").map(String::toInt).forEachIndexed { index, i ->
        if(i%2==0)even.add(index)
        else odd.add(index)

        if(odd.size!=0 && even.size!=0){
            if(even.size>odd.size){
                println(odd[0]+1)
                return
            }else if(odd.size>even.size){
                println(even[0]+1)
                return
            }
        }
    }
}
