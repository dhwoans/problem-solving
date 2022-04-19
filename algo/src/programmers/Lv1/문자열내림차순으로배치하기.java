package programmers.Lv1;

import java.util.Arrays;
import java.util.Collections;

public class 문자열내림차순으로배치하기 {
    public String solution(String s) {
        char[] ch = s.toCharArray();
        Arrays.sort(ch);
        StringBuilder sb = new StringBuilder();
        for (char c : ch) {
            sb.append(c);
        }
        return sb.reverse().toString();
    }
}
