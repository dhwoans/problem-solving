package programmers.Lv2;

import java.util.Arrays;

public class 가장큰수 {
    public String solution(int[] numbers) {
        String answer = "";
        String[] str = new String[numbers.length];
        for (int i = 0; i < str.length; i++) {
            str[i]=Integer.toString(numbers[i]);
        }
        Arrays.sort(str,(o1, o2) -> (o2+o1).compareTo(o1+o2));
        for (String s : str) {
            answer+=s;
        }
        if(str[0].equals("0")) return "0";

        return answer;
    }
}
