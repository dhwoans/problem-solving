package Leetcode.easy;

public class ValidPalindromeII {
    public boolean validPalindrome(String s) {
        int start = 0;
        int end = s.length() - 1;
        boolean chance = true;
        while (start < end) {
            if (s.charAt(start) == s.charAt(end)) {
                start++;
                end--;
            } else {
               return check(start+1,end,s)||check(start,end-1,s);
            }
            
        }
        return true;
    }

    private boolean check(int start,int end,String s) {
        while (start<end){
            if(s.charAt(start)==s.charAt(end)){
                start++;
                end--;
            }else return false;
        }
        return true;
    }
}
