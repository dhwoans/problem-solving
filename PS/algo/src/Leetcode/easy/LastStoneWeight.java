package Leetcode.easy;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class LastStoneWeight {

    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> que = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach((i)->que.add(i));
        while(que.size()!=1){
            int first = que.poll();
            int second = que.poll();

            que.add(Math.abs(first-second));
        }
        return que.poll();
    }
}