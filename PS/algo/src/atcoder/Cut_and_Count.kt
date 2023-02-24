package atcoder

import kotlin.math.max


fun main() {
    val n = readLine()!!.toInt()
    val str = readLine()!!.toCharArray()
    val set = HashSet<Char>()
    val check = IntArray(27).apply{
        for(i in str.indices){
            this[str[i]-'a']++
        }
    }
    var count =0
    var ans =0
    for(i in str.indices)  {
        val indx = str[i]-'a'
        check[indx]--
        //포함되어 있는지
        if(check[indx]!=0){
            if(!set.contains(str[i])){
                set.add(str[i])
            }
        }else if(check[indx]==0){
            set.remove(str[i])
        }
        //최댓값 비교
        ans = max(ans,set.size)
    }
    println(ans)
}