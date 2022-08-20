package leetcode

class RemoveDuplicatesfromSortedArray {
    fun removeDuplicates(nums: IntArray): Int {
        var i =0;
        for (e in nums){
            if(nums[i]!= e){
                i++
                nums[i]=e
            }
        }
        return i+2
    }
}