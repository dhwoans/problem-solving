package Leetcode.easy;

import java.util.ArrayList;
import java.util.List;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode merge = dummy;
        while(list1!=null&&list2!=null){
            if(list1.val>=list2.val){
                merge.next = list2;
                list2= list2.next;
            }else{
                merge.next= list1;
                list1 = list1.next;
            }
            merge = merge.next;
        }
        if(list1==null){
            merge.next = list2;

        }else if(list2==null){
            merge.next = list1;

        }
        return dummy.next;

    }

    private class ListNode {
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
}
