package org.algo.双指针;

import java.util.HashSet;

public class P160getIntersectionNode {
    // 双链表法

    /**
     * 解决这个问题的关键是，通过某些方式，让 p1 和 p2 能够同时到达相交节点 c1。
     * 所以，我们可以让 p1 遍历完链表 A 之后开始遍历链表 B，让 p2 遍历完链表 B 之后开始遍历链表 A，这样相当于「逻辑上」两条链表接在了一起。
     * 如果这样进行拼接，就可以让 p1 和 p2 同时进入公共部分，也就是同时到达相交节点 c1
     */
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while (pa != pb) {
            pa = pa == null ? headB : pa.next;
            pb = pb == null ? headA : pb.next;
        }
        return pa;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        /**
         * 哈希表法：
         * 将链表A存入set中，第一个相同的节点就是重合的节点
         */
        HashSet<ListNode> set = new HashSet<>();
        ListNode temp = headA;
        while (temp != null) {
            set.add(temp);
            temp = temp.next;
        }
        temp = headB;
        while (temp != null) {
            if (set.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    // 方法三,只是一种思路，不推荐，因为修改了链表结构
    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
        ListNode pb = headB;
        // 两个链表首尾相连
        while (pb != null) {
            pb = pb.next;
        }
        pb.next = headA;

        ListNode slow = headB, fast = headB;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            // 相遇的情况
            if (slow == fast) {
                // 寻找相遇点
                ListNode index1 = fast, index2 = headB;
                while (index1 != index2) {
                    index1 = index1.next;
                    index2 = index2.next;
                }
                return index2;
            }
        }
        pb.next = null;
        return null;
    }

    // 方法4

    /**
     * 分别统计两条链表的长度，差值表示非公共部分的长度差，那么让长链表的指针先走差值的步数，再齐头并进，那么如果两个指针相等则是相交的位置。
     */
    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        // 计算两条链表的长度
        for (ListNode p1 = headA; p1 != null; p1 = p1.next) {
            lenA++;
        }
        for (ListNode p2 = headB; p2 != null; p2 = p2.next) {
            lenB++;
        }
        // 让 p1 和 p2 到达尾部的距离相同
        ListNode p1 = headA, p2 = headB;
        if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++) {
                p1 = p1.next;
            }
        } else {
            for (int i = 0; i < lenB - lenA; i++) {
                p2 = p2.next;
            }
        }
        // 看两个指针是否会相同，p1 == p2 时有两种情况：
        // 1、要么是两条链表不相交，他俩同时走到尾部空指针
        // 2、要么是两条链表相交，他俩走到两条链表的相交点
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p1;
    }
}
