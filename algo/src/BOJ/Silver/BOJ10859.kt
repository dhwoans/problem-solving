package BOJ.silver

fun main() {
    val impossible = hashSetOf<Long>(3L, 4L, 7L)
    var num = readLine()!!.toLong()
    //소수판별
    if(num==1L){
        println("no")
        return
    }
    if(!isPrime(num)){
        println("no")
        return
    }
    //뒤집기
    var reverse = 0L
    while (num > 0) {
        if (impossible.contains(num % 10)) {
            println("no")
            return
        } else if (num % 10 == 9L) {
            reverse *= 10
            reverse += 6
        } else if (num % 10 == 6L) {
            reverse *= 10
            reverse += 9
        } else {
            reverse *= 10
            reverse += num % 10
        }

        num /= 10
    }
    //뒤집은수 소수 판별
    if(!isPrime(reverse)){
        println("no")
        return
    }
    println("yes")
}

fun isPrime(n: Long):Boolean {
    var i = 2L
    while (i * i <= n) {
        if (n % i++ == 0L) return false
    }
    return true
}