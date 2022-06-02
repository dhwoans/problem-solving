package programmers.Lv2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class MaximizeFormula {
    boolean[] visited = new boolean[3];
    String[] sign = {"*", "+", "-"};
    private long answer;

    public long solution(String expression) {
        answer = 0;
        // 우선 순위 정하기
        priority(0, 0, new String[3], expression);

        return answer;
    }

    // 우선 순위 정하기
    private void priority(int cnt, int start, String[] input, String expression) {
        if (cnt == 3) {
            // 문자열 쪼개기
            long val = breakString(input, expression, 0);
            answer = Math.max(answer, Math.abs(val));
            return;
        }
        for (int i = 0; i < visited.length; i++) {
            if (visited[i]) continue;
            visited[i] = true;
            input[cnt] = sign[i];
            priority(cnt + 1, i, input, expression);
            visited[i] = false;

        }
    }

    // 문자열 쪼개기
    private long breakString(String[] input, String expression, int cnt) {
        ArrayList<Long> nums = new ArrayList<>();
        ArrayList<String> sign = new ArrayList<>();
        String str= expression.replace("*"," ");
        str= str.replace("-"," ");
        str= str.replace("+"," ");
        StringTokenizer st = new StringTokenizer(str);
        //숫자 저장
        while (st.hasMoreTokens()){
            nums.add(Long.parseLong(st.nextToken()));
        }
        // 부호 저장
        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if(ch>9){
                sign.add(String.valueOf(ch));
            }
        }
        //계산
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < sign.size(); j++) {
                if(input[i].equals(sign.get(j))){
                    if(sign.get(j).equals("*")){

                    }
                }
            }
        }
        return 1L;
    }
}