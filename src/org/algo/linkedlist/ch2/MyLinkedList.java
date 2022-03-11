package org.algo.linkedlist.ch2;

// 单链表实现
public class MyLinkedList {
    /**
     * 元素的个数
     */
    int size;
    /**
     * 虚拟头结点
     */
    ListNode head;

    public MyLinkedList() {
        size = 0;
        head = new ListNode(0);
    }

    /**
     * 获取第index个结点的返回值
     * @param index
     * @return
     */
    public int get(int index) {
        if (index < 0 || index >= size) {
            return -1;
        }
        ListNode cur = head;
        // 遍历结点, 包含一个虚拟头结点，所以查找第index+1个结点
        for (int i = 0; i <= index; i++) {
            cur = cur.next;
        }
        return cur.val;
    }

    public void addAtHead(int val) {
        addAtIndex(0, val);
    }

    public void addAtTail(int val) {
        addAtIndex(size, val);
    }

    /**
     * 在第index前插入一个新节点，如果index等于链表的长度，则说明新插入的是链表的尾结点，如果index大于链表的长度，则返回空
     * @param index
     * @param val
     */
    public void addAtIndex(int index, int val) {
        if (index > size) {
            return;
        }
        if (index < 0) {
            index = 0;
        }
        // 元素个数加一
        size++;
        // 找到要插入节点的前驱
        ListNode pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        ListNode node = new ListNode(val, pre.next);
        pre.next = node;
    }

    public void deleteAtIndex(int index) {
        if (index < 0 || index >= size) {
            return;
        }
        size--;
        // 找到index前一个结点
        ListNode pre = head;
        for (int i = 0; i < index; i++){
            pre = pre.next;
        }
        pre.next = pre.next.next;
    }
}
