package programmers.Lv2;


import java.util.Collections;
import java.util.PriorityQueue;

public class 최솟값만들기 {
    public int solution(int []A, int []B){
        int answer= 0;
        PriorityQueue<Integer> a = new PriorityQueue<Integer>(Collections.reverseOrder());
        PriorityQueue<Integer> b = new PriorityQueue<>();
        for (int i = 0; i < A.length; i++) {
            a.offer(A[i]);
            b.offer(B[i]);
        }
        while (!a.isEmpty()){
            answer+=a.poll()*b.poll();
        }
        return answer;
    }
}