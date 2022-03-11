package org.algo.linkedlist.ch2._019;


public class Solution {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0, head);
        ListNode right = dummy;
        ListNode left = dummy;
        int count = 0;
        // 找到插入位置
        while (right.next != null) {
            if (count >= n) {
                left = left.next;
            }
            right = right.next;
            count++;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
