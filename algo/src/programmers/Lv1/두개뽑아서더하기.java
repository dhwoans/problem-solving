package programmers.Lv1;

import java.util.*;

public class 두개뽑아서더하기 {
    public Integer[] solution(int[] numbers) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                set.add(numbers[i]+numbers[j]);
            }
        }
        Integer[] answer = set.toArray(new Integer[0]);
        Arrays.sort(answer);

        return answer;
    }
}
