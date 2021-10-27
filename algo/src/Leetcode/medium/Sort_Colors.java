package Leetcode.medium;

import java.util.Arrays;

public class Sort_Colors {
    public static void main(String[] args) {
        int[] nums = {2,0,1};
        sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
    private static void sortColors(int[] nums) {
        for (int i = 0; i < nums.length-1; ) {
            boolean flag = true;
            if(nums[i]>nums[i+1]){
                int temp = nums[i];
                nums[i]=nums[i+1];
                nums[i+1]=temp;

                if(i!=0){
                    i--;
                }
                flag=false;
            }
            if(flag)i++;
        }
    }
}
