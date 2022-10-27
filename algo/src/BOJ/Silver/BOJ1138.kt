package BOJ

fun main() {
    val br = System.`in`.bufferedReader()
    val n = br.readLine().toInt()
    val pos = br.readLine().split(" ").map { it.toInt() }.toIntArray()
    val arr = IntArray(n)
    repeat(n) {
        var empty = 0
        for(i in 0 until arr.size){
            if(empty==pos[it]&&arr[i]==0){
                arr[i]=it+1
                break;
            }
            if(arr[i]==0)empty++
        }
    }
    arr.forEach { print("$it ") }

}