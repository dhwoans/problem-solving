package Leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        PriorityQueue<Integer> que = new PriorityQueue<>((o1, o2) -> map.get(o2) - map.get(o1));
        for (int i : nums) {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        for (Integer i : map.keySet()) {
            que.add(i);
        }
        int[] arr = new int[k];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=que.poll();
        }
        return arr;
    }
}
