
fun main() {
    val (n,h,w) = readLine()!!.split(" ").map(String::toInt)
    val arr = CharArray(n){'?'}
    for(i in 0 until h){
        readLine()!!.forEachIndexed{index,it->
            if(it=='?'){
                return@forEachIndexed
            }else{
                arr[index/w]=it
            }
        }
    }
    arr.forEach{
        print(it)
    }
}