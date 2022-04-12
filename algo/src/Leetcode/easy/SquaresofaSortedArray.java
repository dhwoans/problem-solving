package Leetcode.easy;

import java.util.Arrays;


public class SquaresofaSortedArray {
    public int[] sortedSquares(int[] nums) {
        int[] arr = new int[nums.length];
        int start = 0;
        int end =nums.length-1;
        int point =nums.length-1;
        while (point!=-1){
            if(Math.abs(nums[start])>Math.abs(nums[end])){
                arr[point]=nums[start]*nums[start];
                start++;
            }else if(Math.abs(nums[start])<=Math.abs(nums[end])){
                arr[point]=nums[end]*nums[end];
                end--;
            }
            point--;
        }
        return arr;
    }
}

