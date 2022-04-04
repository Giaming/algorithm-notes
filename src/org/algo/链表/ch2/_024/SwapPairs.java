package org.algo.链表.ch2._024;

public class SwapPairs {
    class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        ListNode cur = head;
        while (cur != null && cur.next != null){
            // 移动指针
            ListNode temp = cur;
            cur = cur.next;
            ListNode pointer = cur.next;
            // 交换指针
            prev.next = cur;
            cur.next = temp;
            cur = cur.next;
            prev = cur;
            cur.next = pointer;
            cur = cur.next;
        }
        return dummy.next;
    }


    public ListNode swapPairs2(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while (prev.next != null && prev.next.next != null) {
            ListNode temp = head.next.next;  // 暂时存储next
            prev.next = head.next;
            head.next.next = head;
            head.next = temp;
            prev = head;
            head = head.next;
        }
        return dummy.next;
    }


    /**
     * 递归版本
     */
    public ListNode swapPairs3(ListNode head) {
        // 退出条件
        if (head == null || head.next == null) {
            return head;
        }
        // 获取当前节点的下一个结点
        ListNode next = head.next;
        // 递归
        ListNode newNode = swapPairs3(next.next);
        // 进行交换
        next.next = head;
        head.next = newNode;

        return next;
    }

    public static void main(String[] args) {

    }
}
