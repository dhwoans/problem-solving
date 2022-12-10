package BOJ.Bronze



fun main() {
    val (n, m) = readln().split(" ").map { it.reversed() }
    var l = ""
    var s = ""
    if(n.length<m.length){
        l = m
        s = n
    }else{
        l = n
        s = m
    }
    val ans = IntArray(82)

    for (i in 0 until s.length) {
        ans[i] += (l[i] - '0') + (s[i] - '0')
        if(ans[i]>1){
            ans[i]-=2
            ans[i+1]+=1
        }
    }
    for(i in s.length until l.length){
        ans[i] +=  (l[i]-'0')
        if(ans[i]>1){
            ans[i]-=2
            ans[i+1]+=1
        }
    }
    var flag = false
    for(i in ans.size-1 downTo 0){
        if(!flag && ans[i]==0)continue
        else if(ans[i]==1){
            flag = true
        }
        print(ans[i])
    }
    if(!flag){
        println(0)
    }
}