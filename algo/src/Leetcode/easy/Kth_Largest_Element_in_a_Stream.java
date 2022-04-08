package Leetcode.easy;

import java.util.*;

public class Kth_Largest_Element_in_a_Stream {
    private class KthLargest {
        int k;
        PriorityQueue<Integer> que = new PriorityQueue();

        public KthLargest(int k, int[] nums) {
            this.k = k;
            Arrays.stream(nums).forEach(o->que.add(o));
        }

        public int add(int val) {
            que.add(val);
            while(que.size() > k)
                que.remove();

            return que.peek();
        }
    }

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
