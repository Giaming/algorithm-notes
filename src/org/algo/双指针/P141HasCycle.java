package org.algo.双指针;

/**
 * 判断链表是否包含环属于经典问题了，解决方案也是用快慢指针：
 *
 * 每当慢指针 slow 前进一步，快指针 fast 就前进两步。
 *
 * 如果 fast 最终遇到空指针，说明链表中没有环；如果 fast 最终和 slow 相遇，那肯定是 fast 超过了 slow 一圈，说明链表中含有环。
 */
public class P141HasCycle {
    public boolean hasCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;
        }
        return false;
    }
}
