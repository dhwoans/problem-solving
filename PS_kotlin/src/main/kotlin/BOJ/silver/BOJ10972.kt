
fun main() {
    val n = readLine()!!.toInt()
    val arr = readLine()!!.split(" ").map(String::toInt).toIntArray()

    var point1 = -1
    var point2 = -1
    var point3 = 0
    for(i in 0 until arr.lastIndex){
        if(arr[i]<arr[i+1]){
            point1 = i
            point2 = i+1
        }
    }
    if(point1==-1){
        println(-1)
        return
    }

    for(i in point2 until arr.size){
        if(arr[point1]<arr[i]){
            point3 = i
        }
    }

    val temp= arr[point1]
    arr[point1] = arr[point3]
    arr[point3] = temp

    var start = point2
    var end = arr.lastIndex
    while(start<end){
        val t = arr[start]
        arr[start] = arr[end]
        arr[end] = t
        start++
        end--
    }
    arr.forEach{ print("${it} ")}
}

