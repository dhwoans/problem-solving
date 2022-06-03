package Leetcode.medium;

import java.util.Arrays;

public class HouseRobber {
    public int rob(int[] nums) {
        int answer =0;

        if(nums.length<3){
            for (int num : nums) {
                answer = Math.max(answer, num);
            }
            return answer;
        }else{

            int[] dp = new int[nums.length];

            int start =0;
            dp[0]=nums[0];
            dp[1]=nums[1];
            answer = Math.max(dp[0],dp[1]);
            int sum =0;
            for (int i = 2; i < dp.length; i++) {
                for (int j = start; j < i-1; j++) {
                    sum = Math.max(sum,dp[j]);
                    start = j;
                }
                dp[i]=nums[i]+sum;
                answer = Math.max(answer,dp[i]);
            }
            return answer;
        }
    }
}

