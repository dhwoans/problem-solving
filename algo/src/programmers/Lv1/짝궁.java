package programmers.Lv1;

import java.util.HashMap;

public class 짝궁 {
    public String solution(String X, String Y) {
        StringBuilder answer = new StringBuilder();
        HashMap<Character, Integer> x = new HashMap<>();
        HashMap<Character, Integer> y = new HashMap<>();
        for(int i =0;i<X.length();i++){
           x.put(X.charAt(i),x.getOrDefault(X.charAt(i),0)+1);
        }

        for(int i =0;i<Y.length();i++){
           y.put(Y.charAt(i),y.getOrDefault(Y.charAt(i),0)+1);
        }

        for (int i = 9; i >= 0; i--) {
            char temp = (char) (i+'0');
            if(x.containsKey(temp)&&y.containsKey(temp)){
                int turn = Math.min(x.get(temp),y.get(temp));
                answer.append(Integer.toString(i).repeat(turn));
            }
        }
        if(answer.toString().equals("")) answer = new StringBuilder("-1");
        if(answer.charAt(0)=='0') answer = new StringBuilder("0");
        return answer.toString();
    }
}
