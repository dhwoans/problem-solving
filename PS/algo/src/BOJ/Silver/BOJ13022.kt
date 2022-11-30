package BOJ.Silver

fun main() {
    val str = readln()
    val count = IntArray(4)
    var c = 0
    for (i in str.indices) {
        when (str[i]) {
            'w' -> {
                //횟수 체크
                if (!checkcount(count)) {
                    println(0)
                    return
                }
                c++
            }
            'o' -> {
                // 순서 체크
                if (i - 1 < 0 || str[i - 1] != 'o' && str[i - 1] != 'w') {
                    println(0)
                    return
                }
                count[0] += c
                c = 0
                count[1]++
            }
            'l' -> {
                // 순서 체크
                if (i - 1 < 0 || str[i - 1] != 'l' && str[i - 1] != 'o') {
                    println(0)
                    return
                }
                count[2]++
            }
            'f' -> {
                // 순서 체크
                if (i - 1 < 0 || str[i - 1] != 'f' && str[i - 1] != 'l') {
                    println(0)
                    return
                }
                count[3]++
            }
        }
    }
    count[0]+=c
    if (!checkcount(count)) {
        println(0)
    } else {
        println(1)
    }
}

private fun checkcount(count: IntArray): Boolean {
    for (i in 0 until count.size - 1) {
        if (count[i] != count[i + 1]) {
            return false
        }
    }
    return true
}