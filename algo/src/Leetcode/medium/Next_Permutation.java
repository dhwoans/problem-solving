package Leetcode.medium;



public class Next_Permutation {
    public void nextPermutation(int[] nums) {
        int start = 0;
        int end =0;
        int point =0;
        for (int i = nums.length-1; i >=1; i--) {
            if(nums[i]>nums[i-1]){
                start =i-1;
                end=i;
                break;
            }
        }

        for (int i = nums.length-1; i > start; i--) {
            if(nums[start]<nums[i]){
                point =i;
                break;
            }
        }
        swap(nums, start, point);

        for (int i = end; i <=(end+nums.length-1)/2 ; i++) {
            swap(nums, end+nums.length-1-i, i);
        }
    }

    private void swap(int[] nums, int start, int point) {
        int change = nums[point];
        nums[point] = nums[start];
        nums[start] = change;
    }
}