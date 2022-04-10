package programmers.Lv1;

public class 문자열다루기기본 {
    public boolean solution(String s) {
        boolean answer = true;
        char[] ch = s.toCharArray();
        if(s.length()!=4||s.length()!=6){
            answer=false;
            return answer;
        }
        for (char c : ch) {
            if(c>'9'){
                answer =false;
                break;
            }
        }
        return answer;
    }
}
