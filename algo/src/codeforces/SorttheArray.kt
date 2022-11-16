package codeforces

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toIntArray()
    val check = arr.copyOf()
    check.sort()
    var start = -1
    var end =-1
    for(i in 0 until n){
        if(arr[i]!=check[i]){
            start=i
            break
        }
    }
    if(start!=-1){
        for(j in n-1 downTo 0){
            if(arr[j]!=check[j]){
                end=j
                break
            }
        }
        if(start!=0&&arr[start-1]>arr[end]){
            println("no")
            return
        }
        if(end!=n-1&&arr[end+1]<arr[start]){
            println("no")
            return
        }
        for(i in start until end){
            if(arr[i]<arr[i+1]){
                println("no")
                return
            }
        }
        println("yes")
        println("${start+1} ${end+1}")
        return
    }else{
        println("yes")
        println("1 1")
    }

}
