package programmers.Lv1;

import java.util.ArrayList;
import java.util.List;

public class FailureRate {
    private class info implements Comparable<info>{
        int stage;
        double diff;

        info(int stage,double diff){
            this.stage = stage;
            this.diff = diff;
        }

        @Override
        public int compareTo(info o) {
            if(o.diff==this.diff){
                return Integer.compare(this.stage,o.stage);
            }
            return Double.compare(o.diff,this.diff);
        }
    }
    public int[] solution(int N, int[] stages) {
        int[] arr = new int[N + 2]; // 머무는 사람 수
        List<info> level = new ArrayList<>();   // 답
        int player = stages.length;
        ArrayList<Integer> answer = new ArrayList<>();
        for (int stage : stages) {
            arr[stage]++;
        }
        for (int i = 1; i < arr.length-1; i++) {
            double val = player==0?0:(double) arr[i]/player;
            level.add(new info(i,val));
            player-=arr[i];
        }

        return level.stream().sorted().map(it->it.stage).mapToInt(Integer::intValue).toArray();
    }
}