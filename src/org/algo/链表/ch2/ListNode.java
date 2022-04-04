package org.algo.链表.ch2;

import java.util.HashSet;

class ListNode {
    int val;
    ListNode next;

    public ListNode() {
    }
    public ListNode(int val) {
        this.val = val;
    }
    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Demo {
    public static void test(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
            set.add(i);
        }
        for (Integer i : set) {
            
        }
    }
}