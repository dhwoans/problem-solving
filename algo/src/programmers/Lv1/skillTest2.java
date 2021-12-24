package programmers.Lv1;

/**
 * @packageName : programmers.Lv1
 * @fileName : skillTest2
 * @date : 2021-12-24
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class skillTest2 {
    public int solution(int[] a, int[] b) {
        int answer = 0;
        for (int i = 0; i < a.length; i++) {
            answer+=a[i]*b[i];
        }
        return answer;
    }
}
