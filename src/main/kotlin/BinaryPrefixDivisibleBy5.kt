class BinaryPrefixDivisibleBy5 {
    fun prefixesDivBy5(nums: IntArray): List<Boolean> {
        var sum = 0
        val list = ArrayList<Boolean>()
        for (num in nums) {
            sum = sum * 2 +num
            list.add(sum % 5 == 0)
            sum%=5
        }
        return list
    }
}