package Leetcode.easy;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        int answer = -1;
        while (start <= end) {
            int point = (start + end) / 2;
            if (nums[point] < target) {
                start = point+1;
            } else if (nums[point] > target) {
                end = point-1;
            } else if (nums[point] == target) {
                answer = point;
                break;
            }
        }
        return answer;
    }
}
