package Leetcode.easy;

public class PalindromeNumber {
    public static void main(String[] args) {
        System.out.println(isPalindrome1(123456789));
    }
    public static boolean isPalindrome(int x) {
        StringBuilder sb = new StringBuilder();
        sb.append(x);
        sb.reverse();
        if(Integer.toString(x).equals(sb.toString())){
            return true;
        }
        return false;
    }
    public static boolean isPalindrome1(int x) {
        if (x < 0) return false;
        int oint = x;
        int pop = 0;
        int rev = 0;
        while (x != 0) {
            pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 8)) return false;
            rev = rev * 10 + pop;
        }
        return oint == rev;
    }
}
