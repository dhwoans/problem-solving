package programmers.Lv1;


import java.util.Arrays;

/**
 * @packageName : programmers.Lv1
 * @fileName : skillTest1
 * @date : 2021-12-24
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class skillTest1 {
    public int solution(int[] nums) {
        int answer =0;
        int pick =nums.length/2;
        int result =(int) Arrays.stream(nums).distinct().count();
        answer = Math.min(pick,result);
        return answer;
    }
}
