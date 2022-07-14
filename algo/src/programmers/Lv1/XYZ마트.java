package programmers.Lv1;

import java.util.HashMap;
import java.util.Map;

public class XYZ마트 {
    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        HashMap<String, Integer> wants = new HashMap<>();
        for (int i = 0; i < want.length; i++) {
            wants.put(want[i], number[i]);
        }
        int start = 0;
        int end = 9;

        for (int i = 0; i < 10; i++) {
            if (wants.containsKey(discount[i])) {
                wants.put(discount[i], wants.get(discount[i]) - 1);
            }
        }

        while (end < discount.length-1) {

            boolean isPossible = true;
            for (Integer value : wants.values()) {
                if (value > 0) {
                    isPossible = false;
                    break;
                }
            }
            if (isPossible) {
                answer++;
            }


            if (wants.containsKey(discount[start])) wants.put(discount[start], wants.get(discount[start]) + 1);
            start++;
            end++;
            if (wants.containsKey(discount[end])) wants.put(discount[end], wants.get(discount[end]) - 1);

        }
        boolean isPossible = true;
        for (Integer value : wants.values()) {
            if (value > 0) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            answer++;
        }


        return answer;
    }
}
