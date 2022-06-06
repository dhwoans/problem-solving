package Leetcode.easy;

import java.util.ArrayList;

public class IntersectionofTwoLinkedLists {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode aa = headA;
        ListNode bb = headB;
        while(aa!=bb){
            aa = headA.next;
            bb = headB.next;
            if(aa.val==bb.val){
                return aa;
            }
            if(aa==null){
                aa = headA;
            }
            if(bb==null){
                bb = headB;
            }
        }
        return aa;
    }

    private class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
