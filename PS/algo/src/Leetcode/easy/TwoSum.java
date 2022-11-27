package Leetcode.easy;

import java.util.Arrays;

public class TwoSum {
    public static void main(String[] args) {
        int num[] = {2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(twoSum(num, target)));
    }


    public static int[] twoSum(int[] nums, int target) {
        int[] answer = new int[2];

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length; j++) {
                if (i == j) continue;
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return answer;
    }
}
