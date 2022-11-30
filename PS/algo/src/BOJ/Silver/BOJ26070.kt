package BOJ.Silver
private val p = r()
private val t = r()
private var count = 0L
fun main() {
    while(true){
        for (i in p.indices) {
            if (p[i] < t[i]) {
                count += p[i]
                t[i]-=p[i]
                p[i] = 0
                t[(i+1)%3]+=t[i]/3
                t[i]=0
            }else{
                count += t[i]
                p[i]-=t[i]
                t[i] = 0
            }
        }
        if(t.sum()==0)break
    }
    println(count)
}

private fun r()=readln().split(" ").map(String::toInt).toIntArray()
