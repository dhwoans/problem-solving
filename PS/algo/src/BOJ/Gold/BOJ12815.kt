import kotlin.math.max

fun main() {
    repeat(readln().toInt()) {
        val n = readln().toInt()
        val arr = readln().split(" ").map(String::toInt).toIntArray()
        val count = IntArray(arr.size)
        var one = 0
        var ans =0
        arr.forEachIndexed{index,it->
            if(it==1){
                one++
            }else{
                count[index]=one
            }
        }
        ans = count.sum()
        for(i in arr.indices){
            if(arr[i]==0){
                var temp = 0
                for(j in i+1 until arr.size){
                    if(count[j]>0)temp+=count[j]+1
                }
                ans=max(ans,temp)
            }
        }
        println(ans)
        println(count)
    }


}