package programmers.Lv1;

public class 서울에서김서방찾기 {
    public String solution(String[] seoul) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < seoul.length; i++) {
            if(seoul[i].equals("Kim")){
                sb.append("김서방은 ")
                        .append(i)
                        .append("에 있다");
                return sb.toString();
            }

        }

        return "";
    }
}
