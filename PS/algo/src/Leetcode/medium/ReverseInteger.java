package Leetcode.medium;


public class ReverseInteger {
    public int reverse(int x) {
        int num = 0;
        while (x != 0) {
            if (num > 214748364 || num < -214748364) return 0;
            num = num * 10 + x % 10;
            x /= 10;

        }

        return num;
    }
}
