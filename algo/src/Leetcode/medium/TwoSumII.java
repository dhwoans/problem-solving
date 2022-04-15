package Leetcode.medium;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int[] answer = new int[2];
        int start =0;
        int end = numbers.length-1;
        while (start<end){
            int val = numbers[start]+numbers[end];
            if(val>target)end--;
            else if(val<target)start++;
            else {
                answer[0]=start+1;
                answer[1]=end+1;
                break;
            }
        }

        return answer;
    }
}
