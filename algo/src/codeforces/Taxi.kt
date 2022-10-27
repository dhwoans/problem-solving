package codeforces

fun main() {
    val t=  readLine()!!.toInt()
    val arr = IntArray(5)
    var sum =0;
    readLine()!!.split(" ").map(String::toInt).forEach{
       if(it==4)sum++
       else arr[it]++
    }
    //3 1 합체
    if(arr[3]<=arr[1]){
        arr[1]-=arr[3]
    }else{
        arr[1]=0
    }
    //2 2 합체
    sum+=arr[2]/2
    arr[2]%=2
    //2 1 합체
    if(arr[2]*2<=arr[1]){
        arr[1]-=arr[2]*2
    }else{
        arr[1]=0
    }
    for(i in 1..3){
        if(i==1){
            if(arr[1]%4==0){
                sum+=arr[1]/4
            }else{
                sum+=arr[1]/4+1
            }
        } else if(i==2){
            if(arr[2]%2==0){
                sum+=arr[2]/2
            }else{
                sum+=arr[2]/2+1
            }
        } else{
            sum+=arr[i]
        }
    }
    println(sum)
}