package BOJ.Silver

import kotlin.math.max

fun main() {
    val s = readln()
    var sum =0
    var max =0

    for (i in s) {
        if (i == '(' || i == '{' || i == '[') {
            if (i == '(') sum += 1
            else if (i == '{') sum += 2
            else if (i == '[') sum += 3
        } else if (i == ')' || i == '}' || i == ']') {
            if (i == ')') sum -= 1;
            else if (i == '}') sum -= 2;
            else if (i == ']') sum -= 3;
        } else max = max(max, sum);
    }
    println(max)
}