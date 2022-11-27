package programmers.Lv2;


/**
 * @packageName : programmers.Lv2
 * @fileName : skillTest4
 * @date : 2021-12-29
 * @language : JAVA
 * @classification :
 * @time_limit : 2sec
 * @required_time : 00:40 ~ 01:22
 * @submissions : 1
 * @description :
 **/
public class skillTest4 {
    public int[] solution(String s) {
        int turn = 0;
        int countZero = 0;
        int len = 0;
        while (len != 1) {
            turn++;
            //0이 몇개인지
            String temp = "";
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == '0') {
                    countZero++;
                    continue;
                }
                temp += s.charAt(i);
            }
            //0 없애기
            s = temp;
            //길이 세기
            len = s.length();
            //이진법으로 변환
            s = Integer.toBinaryString(len);
        }
        int[] answer = {turn, countZero};
        return answer;
    }
}
