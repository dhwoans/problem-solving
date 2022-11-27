package programmers.Lv1;

public class 삼진법뒤집기 {
    public int solution(int n) {
        int answer = 0;
        StringBuilder str= new StringBuilder();
        while(n!=0){
            str.append(n % 3);
            n/=3;
        }

        int index = str.length()-1;
        for (char ch : str.toString().toCharArray()) {
            answer += (int) Math.pow(3,index)*(ch-'0');
            index--;
        }
        return answer;
    }
}