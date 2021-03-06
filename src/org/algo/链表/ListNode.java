package org.algo.链表;


/**
 * @author giaming
 * @date 2022/2/27
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pre = null;
        ListNode next;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
