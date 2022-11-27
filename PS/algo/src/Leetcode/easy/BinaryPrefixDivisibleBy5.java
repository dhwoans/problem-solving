package Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryPrefixDivisibleBy5 {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        ArrayList<Boolean> answer = new ArrayList<>();
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum * 2 + nums[i];
            if (sum % 5 == 0) {
                answer.add(true);
            } else {
                answer.add(false);
            }
            sum%=5;
        }

        return answer;
    }
}
