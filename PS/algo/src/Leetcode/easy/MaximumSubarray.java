package Leetcode.easy;

import java.util.Arrays;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        int answer =0;
        dp[0]=nums[0];
        for (int i = 1; i < nums.length; i++) {
           dp[i]= Math.max(nums[i],dp[i-1]+nums[i]);
           answer = Math.max(answer, dp[i]);
        }
        return answer;
    }
}
