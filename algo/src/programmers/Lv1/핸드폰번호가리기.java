package programmers.Lv1;

public class 핸드폰번호가리기 {
    public String solution(String phone_number) {
        String answer = "";
        String end = phone_number.substring(phone_number.length()-4);
        for (int i = 0; i < phone_number.length()-4; i++) {
            answer+="*";
        }
        answer+=end;
        return answer;
    }
}