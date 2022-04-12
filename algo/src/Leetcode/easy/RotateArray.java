package Leetcode.easy;

import java.util.Arrays;


public class RotateArray {
    public void rotate(int[] nums, int k) {
        int[] arr = new int[nums.length];
        int start =0;
        int end=3;
        while(start<nums.length){
            arr[start]=nums[end];
            end++;
            start++;
            if(end==nums.length-1){
                end=0;
            }
        }
        nums = Arrays.copyOf(arr,arr.length);
        System.out.println(Arrays.toString(nums));
    }
}
