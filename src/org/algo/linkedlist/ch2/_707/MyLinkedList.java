package org.algo.linkedlist.ch2._707;
// 双链表实现
class MyLinkedList {
    class ListNode {
        int val;
        ListNode prev;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
    int size;
    ListNode head, tail;

    public MyLinkedList() {
       size = 0;
       head = new ListNode(0);
       tail = new ListNode(0);
       head.next = tail;
       tail.prev = head;
    }

    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        if (index < (size - 1) / 2) {  // 在前面
            for (int i = 0; i <= index; i++) {
                cur = cur.next;
            }
        }else {
            cur = tail;
            for (int i = 0; i <= size - index - 1; i++) {
                cur = cur.prev;
            }
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        ListNode cur = head;
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next =newNode;
        newNode.prev = cur;
        size++;
    }

    public void addAtTail(int val) {
        ListNode cur = tail;
        ListNode newNode = new ListNode(val);
        newNode.next = cur;
        newNode.prev = cur.prev;
        cur.prev.next = newNode;
        cur.prev = newNode;
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        ListNode newNode = new ListNode(val);
        newNode.next = cur.next;
        cur.next.prev = newNode;
        cur.next = newNode;
        newNode.prev = cur;
        size++;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        ListNode cur = head;
        for (int i = 0; i < index; i++) {
           cur = cur.next;
        }
        cur.next.next.prev = cur;
        cur.next = cur.next.next;
        size--;
    }
}