package programmers;

import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] args) {
        solution(new String[]{"119", "97674223", "1195524421"});
    }
    public static boolean solution(String[] phone_book) {
        HashMap<Integer, String> map = new HashMap<>();
        int num =0;
        for (String s : phone_book) {
            map.put(num++,s);
        }
        boolean answer = true;
        return answer;
    }
}
