package Leetcode.easy;

public class Longest_Common_Prefix {
    /**
     *
     * @param strs
     * @return
     */
    static public String longestCommonPrefix(String[] strs) {
        int min =Integer.MAX_VALUE;
        String s ="";
        //짧은 단어 가져오기
        if(strs.length==1)return strs[0];
        for (String str : strs) {
            if(str.length()<min){
                min=str.length();
                s= str;
            }
        }
        //다른 단어와 비교하기
        StringBuilder sb = new StringBuilder();
        boolean flag =false;
        out: for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < strs.length; j++) {
                if(s.charAt(i)==strs[j].charAt(i)){
                    flag=true;
                }else{
                    break out;
                }
            }
            if(flag){
                sb.append(s.charAt(i));
            }
        }
        //출력하기

        return sb.toString();
    }
    public static void main(String[] args) {
        String[] str ={"flower","flower","flower","flower"};
        String answer=longestCommonPrefix(str);
        System.out.println(answer);
    }
}
