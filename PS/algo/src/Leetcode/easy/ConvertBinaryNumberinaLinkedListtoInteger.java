package Leetcode.easy;

import java.util.ArrayList;

public class ConvertBinaryNumberinaLinkedListtoInteger {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    static ArrayList<Integer> arr;

    public static void main(String[] args) {
        ListNode node3 = new ListNode(1);
        ListNode node2 = new ListNode(0, node3);
        ListNode node1 = new ListNode(1, node2);

        arr = new ArrayList<>();
        int result = getDecimalValue(node1);
        System.out.println(result);
    }

    public static int getDecimalValue(ListNode head) {

        while (head!=null){
            arr.add(head.val);
            head=head.next;
        }
        int sum=0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i)==1){
                sum+=(int)Math.pow(2,arr.size()-1-i);
            }
        }
        return sum;
    }

}
