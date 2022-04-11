package programmers.Lv1;

import java.util.ArrayList;

public class 같은숫자는싫어 {
    public int[] solution(int []arr) {
        ArrayList<Integer> nums = new ArrayList<>();
        int target =-1;
        for (Integer num : arr) {
            if(target!=num){
                nums.add(num);
                target = num;
            }
        }
        int[] answer = new int[nums.size()];
        for (int i = 0; i < nums.size(); i++) {
            answer[i]=nums.get(i);
        }
        return answer;
    }
}
