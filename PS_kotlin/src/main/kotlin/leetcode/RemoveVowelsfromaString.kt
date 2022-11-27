package leetcode

class RemoveVowelsfromaString {
    fun removeVowels(s: String): String {
        val list = listOf<Char>('a','e','i','o','u')
        return s.filterNot { ch -> ch in list }
    }
}