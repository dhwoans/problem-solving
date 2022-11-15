package codeforces

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val arr = readln().split(" ").map(String::toInt).toIntArray()

        var flag = false
        for(i in 1 until arr.size){
            if(arr[0]>arr[i]){
                flag =true
            }
        }
        if(flag){
            println("Alice")
        }else{
            println("Bob")
        }

    }
}

