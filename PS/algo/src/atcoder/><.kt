package atcoder



fun main() {
    val str = readLine()!!.toString()
    val arr = IntArray(str.length+1)
    for(i in str.indices){
        if(str[i]=='<'){
            arr[i+1] = arr[i + 1].coerceAtLeast(arr[i] + 1)
        }
    }
    for(i in str.length-1 downTo 0){
        if(str[i]=='>'){
            arr[i]= arr[i].coerceAtLeast(arr[i+1]+1)
        }
    }
    var ans = 0L
    for(i in arr){
        ans +=i
    }
    println(ans)
}
