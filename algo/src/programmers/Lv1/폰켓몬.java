package programmers.Lv1;


import java.util.HashSet;

public class 폰켓몬 {
    public int solution(int[] nums) {
        int answer = 0;
        //뽑을거
        int pick = nums.length/2;
        //종류
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int unit = set.size();
        if(pick<unit)answer = pick;
        else answer = unit;
        return answer;
    }
}
