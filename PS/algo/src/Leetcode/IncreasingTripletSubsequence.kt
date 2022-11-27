package leetcode

class IncreasingTripletSubsequence {
    private val len = ArrayList<Int>().apply{
        this.add((-2e31).toInt())
    }
    fun increasingTriplet(nums: IntArray): Boolean {
        for(i in nums){
            if(i>len.last())len.add(i)
            else {
                val index=binarySearch(i)
                len[index]=i
            }
            //길이검사
            if(len.size>3)return true

        }
        return false
    }
    private fun binarySearch(num:Int):Int{
        var start =0
        var end =len.size
        while(start<end){
            val mid = (start+end)/2
            if(len[mid]>=num)start= mid-1
            else end = mid+1
        }
        return start
    }

}