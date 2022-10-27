package programmers

class 문자열내마음대로정렬 {
    fun solution(strings: Array<String>, n: Int): Array<String> =
        strings.sortedWith(Comparator<String> {
            a,b -> if(a[n]==b[n]) a.compareTo(b)
            else a[n].compareTo(b[n])
        }).toTypedArray()

}