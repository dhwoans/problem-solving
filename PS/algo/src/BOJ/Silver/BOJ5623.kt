package BOJ.Silver

fun main() {
    val n = readln().toInt()
    val arr = Array(n) { IntArray(n) }
    val ans = IntArray(n)
    repeat(n) {
        arr[it] = readln().split(" ").map { it.toInt() }.toIntArray()
    }
    if (n > 2) {
        //계산
        var start = arr[0][1]
        for (i in 2 until n) {
            var sum = 0
            var count = 0
            for (j in 0 until n) {
                if (arr[j][i] == 0) break
                sum += arr[j][i]
                count++
            }
            val result = (sum-start)/count
            ans[i]= result
            if(i==2){
                ans[0]=arr[0][i]-ans[2]
                ans[1]=arr[1][i]-ans[2]
            }
            start += result
        }
    }else{
        ans[0]=1
        ans[1]=arr[0][1]-ans[0]
    }
    ans.forEach{
        print("${it} ")
    }
}