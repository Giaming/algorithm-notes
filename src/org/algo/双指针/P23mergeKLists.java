package org.algo.双指针;

import java.util.PriorityQueue;

public class P23mergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        // 优先级队列，最小堆
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (o1, o2) -> o1.val - o2.val);
        // 将k个链表头加入堆
        for (ListNode head : lists) {
            if (head != null) {
                pq.add(head);
            }
        }
        while (!pq.isEmpty()) {
            // 获取最小节点
            ListNode node = pq.poll();
            p.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }
            p = p.next;
        }
        return dummy.next;
    }
}
