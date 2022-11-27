package BOJ.Gold

fun main() {
    val str1 = readln()
    val str2 = readln()
    var count =0
    val sum1 = IntArray(26)
    val sum2 = IntArray(26)

    for(i in str1.indices){
        sum1[str1[i]-'A']++
        sum2[str2[i]-'A']++
    }

    for(i in str1.lastIndex downTo 0){
        if(str1[i]==str2[str2.lastIndex-count]){
            count++
        }
    }
    var flag =false
    for(i in sum1.indices){
        if(sum1[i]!=sum2[i]){
            flag = true
            break
        }
    }
    if(flag){
        println(-1)
    }else{
        println(str1.length-count)
    }

}
