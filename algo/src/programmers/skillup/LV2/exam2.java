package programmers.skillup.LV2;

import java.util.Arrays;

public class exam2 {
    public int solution(int[] people, int limit) {
        int answer = people.length;
        int count =0;
        Arrays.sort(people);
        int sum=0;
        for (int i = 0; i < people.length; i++) {
            sum+=people[i];
            if(sum>limit){
                sum =people[i];
                count++;
            }
        }
        return answer-count;
    }
}