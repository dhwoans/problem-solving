package programmers.Lv1;

public class x만큼간격이있는n개의숫자 {
    public long[] solution(long x, int n) {
        long[] answer = new long[n];
        for (int i = 1; i <= answer.length; i++) {
            answer[i-1]=i*x;
        }
        return answer;
    }
}
