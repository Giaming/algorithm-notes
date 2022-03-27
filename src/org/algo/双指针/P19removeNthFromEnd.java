package org.algo.双指针;

import java.util.List;

public class P19removeNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 删除倒数第 n 个，要先找倒数第 n + 1 个节点
        ListNode kthPreNode = getKthFromEnd(dummy, n+1);
        kthPreNode.next = kthPreNode.next.next;
        return dummy.next;
    }
    private ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head, slow = head;
        for(int i=0;i<k;i++){
            fast = fast.next;
        }
        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
