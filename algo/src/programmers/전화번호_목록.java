package programmers;

import java.util.HashMap;

public class 전화번호_목록 {
    public static void main(String[] args) {
        boolean answer = solution(new String[]{"123","456","789"});
        System.out.println(answer);
    }
    public static boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i],i);
        }



        return answer;
    }
}
