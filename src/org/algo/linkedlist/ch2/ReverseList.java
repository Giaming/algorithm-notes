package org.algo.linkedlist.ch2;

public class ReverseList {
    /**
     * 头插法
     * @param head
     * @return
     */
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = null;
        while (head != null) {
            ListNode temp = head;
            temp.next = dummy.next;
            dummy.next = temp;
            head = head.next;
        }
        return dummy.next;
    }

    /**
     * 双指针法
     */
    public ListNode reverseList2(ListNode head) {
        ListNode prev = null;
        ListNode temp = null;
        ListNode cur = head;
        while (cur != null) {
            temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }

    /**
     * 递归
     */
    public ListNode reverseList3(ListNode head) {
        return reverse(null, head);
    }

    private ListNode reverse(ListNode prev, ListNode cur) {
        if (cur == null) {
            return prev;
        }
        ListNode temp = cur.next;
        cur.next = prev;
        return reverse(cur, temp);
    }

}
