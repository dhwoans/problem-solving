package BOJ.Gold

fun main() {
    val n = readln().toInt()
    val arr = readln().split(" ").map(String::toInt).toCollection(ArrayList())
    var s = readln().toInt()

    for (i in arr.indices) {
        if(s==0)break
        var flag = false
        var changeIndex =i
        for( j in i until arr.size){
            if(arr[i]<arr[j]){
                if(j-i<=s&&arr[changeIndex]<arr[j]){
                    flag =true
                   changeIndex =j
                }
            }
        }
        //스왑
        if (flag){
            val num = arr[changeIndex]
            arr.removeAt(changeIndex)
            arr.add(i,num)
            s-=changeIndex-i
        }
    }
    arr.forEach {
        print("$it ")
    }
}