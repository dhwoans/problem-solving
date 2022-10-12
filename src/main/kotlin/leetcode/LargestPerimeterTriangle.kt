package leetcode

class LargestPerimeterTriangle {
    fun largestPerimeter(nums: IntArray): Int {
        nums.sortDescending()
        for(i in 0 .. nums.size-3){
            if(nums[i]*nums[i]<nums[i+1]*nums[i+1]+nums[i+2]*nums[i+2]){
                return nums.copyOfRange(i,i+3).sum()
            }
        }
        return 0
    }
}