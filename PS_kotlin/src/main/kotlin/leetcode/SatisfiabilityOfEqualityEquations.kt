package leetcode


private lateinit var arr:IntArray

fun equationsPossible(equations: Array<String>): Boolean {
    arr = IntArray(26){it}

    repeat(equations.size){
        val a = equations[it][0] - 'a'
        val b = equations[it][3] - 'a'

        if(equations[it][1]=='='){
            //연결
            union(a,b)
        }

    }
    repeat(equations.size){
        val a = equations[it][0] - 'a'
        val b = equations[it][3] - 'a'

        if(equations[it][1]=='!'){
            //연결확인
            if(check(a,b))return false
        }

    }
    return true
}

fun union(a:Int,b:Int){
    val aroot = find(a)
    val broot = find(b)

    if(aroot<broot){
        arr[broot]= aroot
    }else{
        arr[aroot] = broot
    }
}
fun check(a:Int,b:Int):Boolean{
    val aroot = find(a)
    val broot = find(b)
    return aroot == broot
}
fun find(a:Int):Int = if(arr[a]!=a) find(arr[a]) else a

