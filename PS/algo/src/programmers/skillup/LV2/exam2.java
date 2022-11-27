package programmers.skillup.LV2;



import java.util.PriorityQueue;

public class exam2 {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        //우선순위큐
        PriorityQueue<Integer> que = new PriorityQueue<>();
        for (int i : scoville) {
            que.add(i);
        }
        while(que.peek()<K){
            if(que.size()<2){
                return -1;
            }
            int one = que.poll();
            int two = que.poll();
            que.add(one+(two*2));
            answer++;
        }
        return answer;
    }
}
