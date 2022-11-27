package Leetcode.easy;

import java.util.Deque;
import java.util.LinkedList;

public class SortArrayByParity {
    public int[] sortArrayByParity(int[] nums) {
//        Deque<Integer> que = new LinkedList<>();
//        for (int num : nums) {
//            if (num % 2 == 0) {
//                que.addFirst(num);
//            } else {
//                que.addLast(num);
//            }
//        }
//        int[] answer = new int[nums.length];
//        for (int i = 0; i < answer.length; i++) {
//            answer[i]=que.pop();
//        }
//        return answer;
        int[]  answer = new int[nums.length];
        int even = 0;
        int odd = nums.length-1;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]%2==0){
                answer[even]=nums[i];
                even++;
            }else{
                answer[odd]=nums[i];
                odd--;
            }
        }
        return answer;
    }
}
