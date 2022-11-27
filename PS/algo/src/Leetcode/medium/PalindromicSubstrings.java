package Leetcode.medium;

public class PalindromicSubstrings {
    public int countSubstrings(String s) {
//        int answer=0;
//        //문자열 자르기
//        for (int i = 0; i < s.length(); i++) {
//            for (int j = 1; j <= s.length(); j++) {
//                if(i+j>s.length())break;
//                String str = s.substring(i,i+j);
//                //팰린드롬 검사하기
//                if(Palindrom(str)){
//                    answer++;
//                }
//            }
//        }
//        return answer;
//    }
//
//    private boolean Palindrom(String str) {
//        int start =0;
//        int end =str.length()-1;
//        while (start<=end){
//            if(str.charAt(start)!=str.charAt(end)){
//                return false;
//            }
//            start++;
//            end--;
//        }
//        return true;
        int answer =0;
        for (int i = 0; i < s.length(); i++) {
            answer +=checkPalindrom(s,i,i);
            answer +=checkPalindrom(s,i,i+1);
        }
        return answer;
    }

    private int checkPalindrom(String s,int left,int right) {
        int count=0;
        while(left>=0&&right<s.length()&&s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
