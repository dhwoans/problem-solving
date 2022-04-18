class BinarySearch {
    fun search(nums: IntArray, target: Int): Int {
        var answer = -1
        var start = 0
        var end =nums.size-1
        while (start<=end){
            val mid  = (start+end)/2
            if(nums[mid]<target)start =mid+1
            else if(nums[mid]>target)end = mid-1
            else return mid
        }
        return answer
    }
}