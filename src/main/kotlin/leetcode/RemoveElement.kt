package leetcode

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i =0
        for(e in nums){
            if(e!=`val`){
                nums[i]=e
                i++
                }
        }
        return i+1
    }
}
