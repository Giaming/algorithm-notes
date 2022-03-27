package org.algo.linkedlist.ch2._07;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    class ListNode {
       int val;
       ListNode next;
       ListNode(int x) {
           val = x;
           next = null;
       }
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        int lenA = 0, lenB = 0;
        // 求链表的长度
        while (curA != null) {
            lenA++;
            curA = curA.next;
        }
        while (curB != null) {
            lenB++;
            curB = curB.next;
        }
        // 重新初始化
        curA = headA;
        curB = headB;
        // 让curA为最长链表的头，lenA为其长度
        if (lenA < lenB) {
            // swap(lenA, lenB)
            int temLen = lenA;
            lenA = lenB;
            lenB = temLen;
            // swap(curA, curB)
            ListNode tmpNode = curA;
            curA = curB;
            curB = tmpNode;
        }
        // 求长度差
        int gap = lenA - lenB;
        // 让curA和curB为同一起点上
        while (gap-- > 0) {
            curA = curA.next;
        }
        // 遍历
        while (curA != null) {
            if (curA == curB) {
                return curA;
            }
            curA = curA.next;
            curB = curB.next;
        }
        return null;
    }
}
